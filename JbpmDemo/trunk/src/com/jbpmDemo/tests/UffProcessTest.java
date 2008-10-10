package com.jbpmDemo.tests;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.jbpmDemo.service.DemoService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UffProcessTest extends AbstractTransactionalJUnit4SpringContextTests implements InitializingBean {

	@Autowired
	private DemoService demoService;

	@Autowired
	private JbpmConfiguration jbpmConfig;

	private static ProcessDefinition uffProcessDef;

	@Override
	public void afterPropertiesSet() throws Exception {
		InputStream in = applicationContext.getResource("classpath:unprocessed_ftp_files.xml").getInputStream();
		uffProcessDef = ProcessDefinition.parseXmlInputStream(in);
	}

	@Test
	public void createUffProcessDefinition() {
		demoService.saveProcessDefinition(uffProcessDef);
		ProcessDefinition uffDefinition = demoService.findProcessDefinition(uffProcessDef.getName());
		assertNotNull(uffDefinition);
	}

	@Test
	public void startUffProcess() {
		demoService.saveProcessDefinition(uffProcessDef);
		ProcessInstance uffProcess = demoService.startProcess(uffProcessDef.getName());
		assertEquals(uffProcess.getRootToken().getNode().getName(), "IT Work");
	}

	@Test
	public void transitionUffProcess() {
		demoService.saveProcessDefinition(uffProcessDef);
		ProcessInstance uffProcess = demoService.startProcess(uffProcessDef.getName());
		uffProcess.signal("Transfer to ET");
		assertEquals(uffProcess.getRootToken().getNode().getName(), "ET Work");

		uffProcess.signal("Transfer to IT");
		assertEquals(uffProcess.getRootToken().getNode().getName(), "IT Work");

		uffProcess.signal("Transfer to ET");
		assertEquals(uffProcess.getRootToken().getNode().getName(), "ET Work");

		demoService.saveProcessInstance(uffProcess);

		ProcessInstance newUffProcess = demoService.findProcessInstances(uffProcessDef.getName()).get(0);
		assertNotNull(newUffProcess);
		assertEquals(newUffProcess.getRootToken().getNode().getName(), "ET Work");

	}

	@Test
	public void completeUffProcess() {
		demoService.saveProcessDefinition(uffProcessDef);
		ProcessInstance uffProcess = demoService.startProcess(uffProcessDef.getName());
		uffProcess.signal("Finished");
		assertEquals(uffProcess.getRootToken().getNode().getName(), "end");
		assertTrue(uffProcess.hasEnded());
	}

	@Test
	public void taskManagement() {
		demoService.saveProcessDefinition(uffProcessDef);
		ProcessInstance uffProcess = demoService.startProcess(uffProcessDef.getName());
		demoService.saveProcessInstance(uffProcess);
		Token token = uffProcess.getRootToken();

		TaskMgmtInstance taskMgmtInst = uffProcess.getTaskMgmtInstance();
		Collection<TaskInstance> taskInstances = taskMgmtInst.getTaskInstances();
		logger.debug("Tasks after saving of new process instance: ");
		printTaskInstances(taskInstances);
		logger.debug("\n\n");
		assertEquals(1, taskInstances.size());

		JbpmContext jbpmContext = jbpmConfig.createJbpmContext();
		List<TaskInstance> itTaskList = jbpmContext.getTaskList("IT");
		logger.debug("Num of IT Task: " + itTaskList.size());
		assertEquals(itTaskList.size(), 1);

		// move to ET
		uffProcess.signal("Transfer to ET");
		taskInstances = taskMgmtInst.getTaskInstances();
		logger.debug("Tasks after moving to ET w/o Saving");
		printTaskInstances(taskInstances);
		logger.debug("\n\n");
		assertEquals(2, taskInstances.size());
		List<TaskInstance> etTaskList = jbpmConfig.getCurrentJbpmContext().getTaskList("ET");
		logger.debug("Num of ET Task: " + etTaskList.size());
		assertEquals(etTaskList.size(), 1);

		// move back to IT - should not create new task instances
		uffProcess.signal("Transfer to IT");
		taskInstances = taskMgmtInst.getTaskInstances();
		assertEquals(3, taskInstances.size());

		itTaskList = jbpmConfig.getCurrentJbpmContext().getTaskList("IT");
		logger.debug("Num of IT Task: " + itTaskList.size());
		assertEquals(itTaskList.size(), 1);
	}

	private void printTaskInstances(Collection<TaskInstance> taskInstances) {
		int count = 0;
		for (TaskInstance taskInstance : taskInstances) {
			logger.debug("Task: " + count);
			logger.debug("\tname: " + taskInstance.getName());
			if (taskInstance.getCreate() == null) {
				logger.debug("\tCreated: " + "NULL");
			}
			else {
				logger.debug("\tCreated: " + DateFormatUtils.format(taskInstance.getCreate(), "EEE, d MMM yyyy HH:mm:ss"));
			}

			if (taskInstance.getStart() == null) {
				logger.debug("\tStarted: " + "NULL");
			}
			else {
				logger.debug("\tStarted: " + DateFormatUtils.format(taskInstance.getStart(), "EEE, d MMM yyyy HH:mm:ss"));
			}
			if (taskInstance.getEnd() == null) {
				logger.debug("\tEnd: " + "NULL");
			}
			else {
				logger.debug("\tEnded: " + DateFormatUtils.format(taskInstance.getEnd(), "EEE, d MMM yyyy HH:mm:ss"));
			}

			++count;
		}
	}
}
