package com.jbpmDemo.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.jbpm.graph.exe.ProcessInstance;

/**
 * @author Josh Long <p/> this is designed to handle any and all workflow
 *         requirements
 */
public interface WorkflowService extends Serializable {
	long getProcessInstanceIdForTaskInstance(final long taskInstanceId);

	Object getProcessVariable(long processinstanceid, String key);

	void setProcessVariableFor(long processinstanceid, String name, Object val);

	void setProcessVariablesFor(long processInstanceId, Map<String, Object> vals);

	public Long lockNextTaskInstanceByActor(String actor);

	public Long lockNextTaskInstanceByActorAndCriteria(String actor, Map<String, Object> vars);

	public Long getNextTaskInstanceByActor(String actor);

	public Long getNextTaskInstanceByActorAndCriteria(String actor, Map<String, Object> vars);

	ProcessInstance createProcessInstance(String flowName, Map<String, Object> vars);

	ProcessInstance createProcessInstance(String flowName);

	void startProcessInstance(long processInstanceId);

	void lockTaskInstance(long taskInstanceId, String actor);

	void unlockTaskInstance(long taskInstanceId);

	void completeTaskInstance(long taskInstanceId);

	Collection<Long> getOpenTaskInstancesByActor(String actor);

	Collection<Long> getOpenTaskInstancesByActorAndCriteria(String actor, Map<String, Object> criteria);

	ProcessInstance getProcessInstanceById(Long processId);

	ProcessInstance createNewProcessInstance(final String defS);
}
