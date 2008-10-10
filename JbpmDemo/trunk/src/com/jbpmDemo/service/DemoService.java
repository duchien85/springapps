package com.jbpmDemo.service;

import java.util.List;
import java.util.Map;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;

public interface DemoService {

	List<ProcessDefinition> findLatestProcessDefinitions();

	ProcessDefinition findProcessDefinition(String name);

	List<ProcessInstance> findProcessInstances(String name);

	void saveProcessDefinition(ProcessDefinition processDefinition);

	void saveProcessInstance(ProcessInstance processInstance);

	ProcessInstance startProcess(String name);

	ProcessInstance startProcess(String name, Map<String, Object> vars);

}
