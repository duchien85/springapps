package com.jbpmDemo.tests;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.jbpm.JbpmConfiguration;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UffProcessTest extends AbstractJUnit4SpringContextTests implements InitializingBean {

	@Autowired
	private JbpmConfiguration jbpmConfig;

	private ProcessDefinition uffProcessDef;
	private ProcessInstance uffProcess;
	private Token rootToken;
	private TaskMgmtInstance taskMgmtInstance;

	@Override
	public void afterPropertiesSet() throws Exception {
		InputStream in = applicationContext.getResource("classpath:unprocessed_ftp_files.xml").getInputStream();
		uffProcessDef = ProcessDefinition.parseXmlInputStream(in);
	}

	@Before
	public void before() {
		uffProcess = uffProcessDef.createProcessInstance();
		rootToken = uffProcess.getRootToken();
		taskMgmtInstance = uffProcess.getTaskMgmtInstance();

	}

	@After
	public void after() {
		uffProcess = null;
		rootToken = null;
		taskMgmtInstance = null;
	}

	@Test
	public void processCreated() {
		assertTrue(rootToken.getNode().getName().equals("start"));
	}

	@Test
	public void startUffProcess() {
		uffProcess.signal();
		assertTrue(rootToken.getNode().getName().equals("IT Work"));
		Collection tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		assertEquals(tasks.size(), 1);
		TaskInstance itTask = (TaskInstance) CollectionUtils.get(tasks, 0);
		assertNull(itTask.getActorId());
		Set pooledActors = itTask.getPooledActors();
		assertEquals(pooledActors.size(), 1);
		PooledActor pa = (PooledActor) CollectionUtils.get(pooledActors, 0);
		assertEquals(pa.getActorId(), "ROLE_SG ELIGIBILITY OPERATIONS");
	}

	@Test
	public void moveFromItToEtAfterTaskComplete() {
		uffProcess.signal();
		Collection tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		assertEquals(tasks.size(), 1);
		TaskInstance itTask = (TaskInstance) CollectionUtils.get(tasks, 0);
		assertTrue(itTask.getName().equals("Unprocessed Ftp Files Exist"));
		itTask.end("Transfer to ET");
		assertEquals(rootToken.getNode().getName(), "ET Work");

		tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		assertEquals(tasks.size(), 1);
		itTask = (TaskInstance) CollectionUtils.get(tasks, 0);
		assertTrue(itTask.getName().equals("Unprocessed Ftp Files Exist"));

		Set pooledActors = itTask.getPooledActors();
		assertEquals(pooledActors.size(), 1);
		PooledActor pa = (PooledActor) CollectionUtils.get(pooledActors, 0);
		assertEquals(pa.getActorId(), "ROLE_SG ELIGIBILITY TEAM");
	}

	/*
	 * @Test(expected = Exception.class) public void
	 * moveFromItToEtBeforeTaskComplete() { uffProcess.signal();
	 * uffProcess.signal("Transfer to ET"); }
	 */

	/*
	 * @Test(expected = Exception.class) public void
	 * moveFromItToFinishedBeforeTaskComplete() { uffProcess.signal();
	 * uffProcess.signal("Finished"); }
	 */

	@Test
	public void ItFinish() {
		uffProcess.signal();
		TaskInstance ti = (TaskInstance) CollectionUtils.get(taskMgmtInstance.getUnfinishedTasks(rootToken), 0);
		ti.end("Finished");
		assertEquals(rootToken.getNode().getName(), "end");
		assertEquals(taskMgmtInstance.getUnfinishedTasks(rootToken).size(), 0);
	}

	@Test(expected = Exception.class)
	public void EtFinishBeforeTaskComplete() {
		uffProcess.signal();
		Collection tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		TaskInstance itTask = (TaskInstance) CollectionUtils.get(tasks, 0);
		itTask.end("Transfer to ET");
		assertEquals(rootToken.getNode().getName(), "ET Work");
		uffProcess.signal("Finish");
	}

	@Test
	public void moveFromEtToCm() {
		uffProcess.signal();
		TaskInstance ti = (TaskInstance) CollectionUtils.get(taskMgmtInstance.getUnfinishedTasks(rootToken), 0);
		ti.end("Transfer to ET");
		ti = (TaskInstance) CollectionUtils.get(taskMgmtInstance.getUnfinishedTasks(rootToken), 0);
		ti.end("Transfer to CM");
		assertEquals(rootToken.getNode().getName(), "CM Work");

		Collection tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		assertEquals(tasks.size(), 1);
		ti = (TaskInstance) CollectionUtils.get(tasks, 0);
		assertTrue(ti.getName().equals("Unprocessed Ftp Files Exist"));

		Set pooledActors = ti.getPooledActors();
		assertEquals(pooledActors.size(), 1);
		PooledActor pa = (PooledActor) CollectionUtils.get(pooledActors, 0);
		assertEquals(pa.getActorId(), "ROLE_SG CLIENT MGMT");

	}

	/*
	 * @Test(expected = Exception.class) public void moveFromItToCM() {
	 * uffProcess.signal(); Collection tasks =
	 * taskMgmtInstance.getUnfinishedTasks(rootToken); TaskInstance ti =
	 * (TaskInstance) CollectionUtils.get(tasks, 0); ti.end("Transfer to CM"); }
	 */

	/*
	 * @Test(expected = Exception.class) public void moveBackToItFromEt() {
	 * uffProcess.signal(); Collection tasks =
	 * taskMgmtInstance.getUnfinishedTasks(rootToken); TaskInstance ti =
	 * (TaskInstance) CollectionUtils.get(tasks, 0); ti.end("Transfer to ET");
	 * 
	 * tasks = taskMgmtInstance.getUnfinishedTasks(rootToken); ti =
	 * (TaskInstance) CollectionUtils.get(tasks, 0); ti.end("Transfer to IT"); }
	 */

	@Test
	public void EtFinish() {
		uffProcess.signal();
		Collection tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		TaskInstance ti = (TaskInstance) CollectionUtils.get(tasks, 0);
		ti.end("Transfer to ET");

		tasks = taskMgmtInstance.getUnfinishedTasks(rootToken);
		ti = (TaskInstance) CollectionUtils.get(tasks, 0);
		ti.end("Finished");
		assertEquals(rootToken.getNode().getName(), "end");
		assertEquals(taskMgmtInstance.getUnfinishedTasks(rootToken).size(), 0);
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
