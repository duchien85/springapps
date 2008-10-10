package com.jbpmDemo.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jbpm.JbpmConfiguration;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

public class PgpProblemServiceImp implements PgpProblemService, ApplicationContextAware {
	private final Log logger = LogFactory.getLog(PgpProblemServiceImp.class);
	private AbstractApplicationContext appContext;
	private JbpmTemplate jbpmTemplate;
	private JbpmConfiguration jbpmConfiguration;

	public JbpmTemplate getJbpmTemplate() {
		return jbpmTemplate;
	}

	public void setJbpmTemplate(JbpmTemplate jbpmTemplate) {
		this.jbpmTemplate = jbpmTemplate;
	}

	public JbpmConfiguration getJbpmConfiguration() {
		return jbpmConfiguration;
	}

	public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration) {
		this.jbpmConfiguration = jbpmConfiguration;
	}

	@Override
	public void beginProcess(ProcessInstance processInstance) {
		logger.warn("Beginning Process: " + processInstance.getId());
	}

	@Override
	public void completeProcess(ProcessInstance processInstance) {
		logger.warn("Completing Process: " + processInstance.getId());
	}

	@Override
	public ProcessInstance createNewProcess() {
		logger.warn("Created Process: ");
		return null;
	}

	@Override
	public StringBuffer getProcessInfo(ProcessInstance processInstance) {
		logger.warn("Getting Info for Process: " + processInstance.getId());
		return null;
	}

	@Override
	public void moveToEt(ProcessInstance processInstance) {
		logger.warn("Moving to ET: " + processInstance.getId());
	}

	@Override
	public void moveToIt(ProcessInstance processInstance) {
		logger.warn("Moving to IT: " + processInstance.getId());
	}

	/*
	 * @Override public ProcessDefinition createProcessDefinition(String file) {
	 * 
	 * return (ProcessDefinition) jbpmTemplate.execute(new JbpmCallback() {
	 * public Object doInJbpm(JbpmContext jbpmContext) throws JbpmException {
	 * ProcessDefinition processDefinition; try { String resource = "classpath:"
	 * + "Test.xml"; InputStream in =
	 * appContext.getResource(resource).getInputStream(); processDefinition =
	 * ProcessDefinition.parseXmlInputStream(in);
	 * logger.debug("Read new process definition: " +
	 * processDefinition.getName()); logger.debug("Config: " +
	 * getJbpmConfiguration()); logger.debug("Context: " +
	 * getJbpmConfiguration().getCurrentJbpmContext());
	 * getJbpmConfiguration().getCurrentJbpmContext
	 * ().deployProcessDefinition(processDefinition);
	 * logger.debug("deployed definition: " + processDefinition.getName()); }
	 * catch (IOException e) { e.printStackTrace(); return null; } return
	 * processDefinition; } });
	 * 
	 * }
	 */

	@Override
	public ProcessDefinition createProcessDefinition(String file) {
		logger.debug("Config: " + getJbpmConfiguration());
		ProcessDefinition processDefinition;
		try {
			String resource = "classpath:" + "Test.xml";
			InputStream in = appContext.getResource(resource).getInputStream();
			processDefinition = ProcessDefinition.parseXmlInputStream(in);
			logger.debug("Read new process definition: " + processDefinition.getName());
			logger.debug("Config: " + getJbpmConfiguration());
			logger.debug("Context: " + getJbpmConfiguration().getCurrentJbpmContext());
			getJbpmConfiguration().getCurrentJbpmContext().deployProcessDefinition(processDefinition);
			logger.debug("deployed definition: " + processDefinition.getName());
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return processDefinition;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = (AbstractApplicationContext) applicationContext;
	}
}
