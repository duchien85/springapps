package com.jbpmDemo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.transaction.annotation.Transactional;
import org.springmodules.workflow.jbpm31.JbpmCallback;

/**
 * Integration point with our workflow engine -- should be able to query
 * worklists, kick off new process instances, all from here
 * 
 * @author Josh Long
 */
@Transactional public class WorkflowServiceImpl extends BaseService implements WorkflowService {
	public static long[] deserializeIdList(String stringReprOfIdList) {
		if (!StringUtils.isEmpty(stringReprOfIdList)) {
			String[] parts = stringReprOfIdList.split(",");
			long[] arrayOfLongs = new long[parts.length];
			for (int i = 0; i < parts.length; i++) {
				arrayOfLongs[i] = Long.parseLong(parts[i]);
			}
			return arrayOfLongs;
		}
		return new long[] {};
	}

	public Long lockNextTaskInstanceByActor(String actor) {
		Long tid = getNextTaskInstanceByActor(actor);
		if (null != tid) {
			this.lockTaskInstance(tid, actor);
		}
		return tid;
	}

	public Long lockNextTaskInstanceByActorAndCriteria(String actor, Map<String, Object> vars) {
		Long tid = getNextTaskInstanceByActorAndCriteria(actor, vars);
		if (tid != null) {
			lockTaskInstance(tid, actor);
		}
		return tid;
	}

	public static String serializeIdList(Long... ids) {
		return StringUtils.join(ids, ",");
	}

	public long getProcessInstanceIdForTaskInstance(final long taskInstanceId) {
		return (Long) getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				TaskInstance ti = getTaskInstance(taskInstanceId);
				ProcessInstance pi = ti.getToken().getProcessInstance();
				return pi.getId();
			}
		});
	}

	public void startProcessInstance(final long processInstanceId) {
		jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				ProcessInstance processInstance = jbpmContext.getProcessInstance(processInstanceId);
				processInstance.signal();
				jbpmContext.save(processInstance);
				return null;
			}
		});
	}

	public ProcessInstance createProcessInstance(final String flowName, final Map<String, Object> vars) {
		return (ProcessInstance) jbpmTemplate.execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				ProcessInstance processInstance = createNewProcessInstance(flowName);
				jbpmContext.save(processInstance);
				if (null != vars) {
					for (String varName : vars.keySet()) {
						setProcessVariableFor(processInstance.getId(), varName, vars.get(varName));
					}
				}
				jbpmContext.save(processInstance);
				long procId = processInstance.getId();
				processInstance = jbpmContext.getProcessInstance(procId);
				jbpmContext.save(processInstance);

				return processInstance;
			}
		});
	}

	public ProcessInstance createProcessInstance(String flowName) {
		return createProcessInstance(flowName, null);
	}

	public void lockTaskInstance(final long taskInstanceId, final String actor) {
		if (taskInstanceId <= 0) {
			return;
		}
		getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				TaskInstance taskInstance = getTaskInstance(taskInstanceId);
				if (taskInstance != null) {
					if (taskInstance.getStart() == null && !taskInstance.isCancelled() && !taskInstance.hasEnded()) {
						taskInstance.start(actor);
						// loggingUtils.log("started " + taskInstanceId +
						// " with actor " + actor);
					}
				}
				else {
					// loggingUtils.log("task instance " + taskInstanceId +
					// "is null! ");
				}
				return null;
			}
		});
	}

	public Object getProcessVariable(long procinstId, String key) {
		Map<String, Object> vars = getProcessVariablesFor(procinstId);
		if (vars != null && vars.containsKey(key)) {
			return vars.get(key);
		}
		return null;
	}

	public ProcessInstance getProcessInstanceById(Long processId) {
		ProcessInstance pi = getJbpmTemplate().findProcessInstance(processId);
		Hibernate.initialize(pi);
		return pi;
	}

	protected TaskInstance getTaskInstance(final long tid) {
		return (TaskInstance) getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				try {
					return _taskInstance(jbpmContext.getSession(), jbpmContext, tid);
				}
				catch (Throwable throwable) {
					// getLoggingUtils().log(throwable);
				}
				return null;
			}
		});
	}

	private TaskInstance _taskInstance(Session session, JbpmContext ctx, long taskInstanceId) throws Throwable {
		TaskInstance taskInstance = null;
		try {
			taskInstance = (TaskInstance) session.load(TaskInstance.class, taskInstanceId, LockMode.UPGRADE);
		}
		catch (Throwable e) {
			// getLoggingUtils().log(e);
			throw new JbpmException("couldn't get task instance '" + taskInstanceId + "'", e);
		}
		return taskInstance;
	}

	public void unlockTaskInstance(final long taskInstanceId) {
		if (taskInstanceId != 0) {
			getJbpmTemplate().execute(new JbpmCallback() {
				public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
					TaskInstance ti = getTaskInstance(taskInstanceId);
					ti.suspend();
					jbpmContext.save(ti);
					return null;
				}
			});
		}
	}

	public void completeTaskInstance(final long taskInstanceId) {
		if (taskInstanceId == 0) {
			return;
		}
		getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				TaskInstance taskInstance = getTaskInstance(taskInstanceId);
				if (taskInstance.getEnd() == null && !taskInstance.hasEnded()) {
					taskInstance.end();
					jbpmContext.save(taskInstance);
				}
				return null;
			}
		});
	}

	public void setProcessVariableFor(final long processinstanceid, final String name, final Object val) {
		getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				final String fName = StringUtils.defaultString(name);
				boolean wasValNull = val == null;
				final String fVal = wasValNull ? StringUtils.EMPTY : val.toString();
				// getLoggingUtils().log(String.format("setting [%s]=[%s] ",
				// fName, fVal, fName, !wasValNull ? "not " : ""));
				ProcessInstance processInstance = getProcessInstanceById(processinstanceid);
				processInstance.getContextInstance().setVariable(name, val);
				context.save(processInstance);
				return null;
			}
		});
	}

	public void setProcessVariablesFor(long processInstanceId, Map<String, Object> vals) {
		for (String varName : vals.keySet()) {
			setProcessVariableFor(processInstanceId, varName, vals.get(varName));
		}
	}

	public Long getNextTaskInstanceByActorAndCriteria(final String actor, final Map<String, Object> vars) {
		Object result = getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				Collection<Long> tis = getOpenTaskInstancesByActorAndCriteria(actor, vars);
				if (tis != null && tis.size() > 0) {
					return tis.iterator().next();
				}
				return null;
			}
		});
		if (null == result) {
			return null;
		}
		return ((Long) result);
	}

	public Long getNextTaskInstanceByActor(final String actor) {
		return getNextTaskInstanceByActorAndCriteria(actor, null);
	}

	public Map<String, Object> getProcessVariablesFor(final long processInstanceId) {
		Map<String, Object> variableMap = (Map<String, Object>) getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
				ProcessInstance pi = jbpmContext.getProcessInstance(processInstanceId);
				Map vars = pi.getContextInstance().getVariables();
				return vars;
			}
		});
		return variableMap;
	}

	public Collection<Long> getOpenTaskInstancesByActorAndCriteria(final String actor, final Map<String, Object> criteria) {
		List tis = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Collection<Long> tasks = new ArrayList<Long>();

				String hql = "SELECT ti.id FROM TaskInstance ti WHERE ti.actorId=  :actor and ti.isOpen = true and ti.isSuspended = false   ";// +
				Map<String, Object> namedParamsAndVals = new HashMap<String, Object>();
				namedParamsAndVals.put("actor", actor);
				if (criteria != null && criteria.keySet().size() > 0) {
					hql += " and ";

					String q = " (ti.token.id IN ( select li.token.id from LongInstance li WHERE li.value = %s AND li.name =  %s ) OR "
							+ "ti.token.id IN ( select si.token.id from StringInstance si WHERE si.value = '%s' AND si.name =  %s))";
					Collection<String> crits = new ArrayList<String>();
					int ctr = 0;
					for (String key : criteria.keySet()) {

						Object val = criteria.get(key);
						String sval = val.toString();

						String nameParam = "name" + ctr;
						String valParam = "value" + ctr;
						namedParamsAndVals.put(nameParam, key);
						namedParamsAndVals.put(valParam, val);
						crits.add(String.format(q, ":" + valParam, ":" + nameParam, ":" + valParam, ":" + nameParam));

						ctr += 1;

					}
					hql += StringUtils.join(crits.iterator(), " AND ");
				}
				ArrayList<String> keys = new ArrayList<String>();
				ArrayList<Object> vals = new ArrayList<Object>();
				for (String key : namedParamsAndVals.keySet()) {
					Object val = namedParamsAndVals.get(key);
					if (val instanceof Number && !(val instanceof Double) && !(val instanceof Float))
						vals.add(((Number) val).longValue());
					else if (val instanceof Double || val instanceof Float)
						vals.add(((Number) val).doubleValue());
					else
						vals.add(val);
					keys.add(key);
				}
				String[] paramNames = keys.toArray(new String[keys.size()]);
				Object[] paramVals = vals.toArray();
				tasks = getHibernateTemplate().findByNamedParam(hql, paramNames, paramVals);
				return tasks;

			}
		});

		// getLoggingUtils().log("tis.size():" + tis.size());
		return tis;

	}

	public Collection<Long> getOpenTaskInstancesByActor(final String actor) {
		Collection<Long> tis = getOpenTaskInstancesByActorAndCriteria(actor, null);
		return tis;
	}

	public ProcessInstance createNewProcessInstance(final String defS) {
		ProcessInstance inst = (ProcessInstance) getJbpmTemplate().execute(new JbpmCallback() {
			public Object doInJbpm(JbpmContext ctx) throws JbpmException {
				ProcessDefinition def = ctx.getGraphSession().findLatestProcessDefinition(defS);
				ProcessInstance inst = def.createProcessInstance();
				return inst;
			}
		});
		return inst;
	}
}
