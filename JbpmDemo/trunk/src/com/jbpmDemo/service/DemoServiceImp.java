package com.jbpmDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.JbpmContext;
import org.jbpm.JbpmException;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.transaction.annotation.Transactional;
import org.springmodules.workflow.jbpm31.JbpmCallback;

public class DemoServiceImp extends BaseService implements DemoService {

	@Override
	@Transactional
	public void saveProcessDefinition(final ProcessDefinition pd) {
		getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				context.deployProcessDefinition(pd);
				return null;
			}
		});
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProcessDefinition> findLatestProcessDefinitions() {
		return (List<ProcessDefinition>) getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				return context.getGraphSession().findLatestProcessDefinitions();
			}
		});

	}

	@Override
	@Transactional(readOnly = true)
	public ProcessDefinition findProcessDefinition(final String name) {
		return (ProcessDefinition) getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				return context.getGraphSession().findLatestProcessDefinition(name);
			}
		});
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProcessInstance> findProcessInstances(final String name) {
		// List of Process Instances across all versions
		return (List<ProcessInstance>) getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				List<ProcessInstance> piList = new ArrayList<ProcessInstance>();
				List<ProcessDefinition> pdList = context.getGraphSession().findAllProcessDefinitionVersions(name);

				for (ProcessDefinition pd : pdList) {
					List<ProcessInstance> pisForVersion = context.getGraphSession().findProcessInstances(pd.getId());
					piList.addAll(pisForVersion);
				}
				return piList;
			}
		});
	}

	@Transactional
	@Override
	public ProcessInstance startProcess(String name) {
		return startProcess(name, null, new HashMap<String, Object>());
	}

	@Transactional
	@Override
	public ProcessInstance startProcess(final String name, final String businessKey, final Map<String, Object> vars) {
		return (ProcessInstance) getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				ProcessDefinition pd = context.getGraphSession().findLatestProcessDefinition(name);
				ProcessInstance pi = pd.createProcessInstance(vars, businessKey);
				context.save(pi);

				if (pd.getTaskMgmtDefinition().getStartTask() == null) {
					pi.signal();
				}
				else {
					TaskInstance startTask = pi.getTaskMgmtInstance().createStartTaskInstance();
					startTask.end();
				}
				return pi;
			}
		});
	}

	@Transactional
	@Override
	public void saveProcessInstance(final ProcessInstance processInstance) {
		getJbpmTemplate().execute(new JbpmCallback() {
			@Override
			public Object doInJbpm(JbpmContext context) throws JbpmException {
				context.save(processInstance);
				return null;
			}
		});
	}
}
