package com.jbpmDemo.service;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PgpProblemService {

	ProcessDefinition createProcessDefinition(String fileName);

	ProcessInstance createNewProcess();

	void beginProcess(ProcessInstance processInstance);

	void moveToIt(ProcessInstance processInstance);

	void moveToEt(ProcessInstance processInstance);

	void completeProcess(ProcessInstance processInstance);

	StringBuffer getProcessInfo(ProcessInstance processInstance);

}
