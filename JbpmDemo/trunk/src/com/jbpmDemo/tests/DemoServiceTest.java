package com.jbpmDemo.tests;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.jbpmDemo.service.DemoService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DemoServiceTest extends AbstractTransactionalJUnit4SpringContextTests implements InitializingBean {

	@Autowired
	private DemoService demoService;

	private static ProcessDefinition testProcess;

	@Override
	public void afterPropertiesSet() throws Exception {
		InputStream in = applicationContext.getResource("classpath:Test.xml").getInputStream();
		testProcess = ProcessDefinition.parseXmlInputStream(in);
	}

	@Test
	public void testFindProcessDefinition() {
		demoService.saveProcessDefinition(testProcess);
		ProcessDefinition processDefinition = demoService.findProcessDefinition(testProcess.getName());
		assertNotNull(processDefinition);
	}

	@Test
	public void testFindProcessInstances() {
		List<ProcessInstance> processInstances = demoService.findProcessInstances(testProcess.getName());
		assertEquals(0, processInstances.size());
		demoService.saveProcessDefinition(testProcess);
		ProcessInstance pi = testProcess.createProcessInstance();
		demoService.saveProcessInstance(pi);
		processInstances = demoService.findProcessInstances(testProcess.getName());
		assertEquals(1, processInstances.size());
	}

	@Test
	public void testSaveProcessDefinition() throws Exception {
		assertEquals(0, demoService.findLatestProcessDefinitions().size());
		demoService.saveProcessDefinition(testProcess);
		assertEquals(1, demoService.findLatestProcessDefinitions().size());
	}

	@Test
	public void testStartProcess() {
		demoService.saveProcessDefinition(testProcess);
		ProcessInstance pi = demoService.startProcess(testProcess.getName());
		Token token = pi.getRootToken();
		assertEquals("s", token.getNode().getName());

		// signal to end
		// assert state TheEnd
		pi.signal();
		assertEquals("end", token.getNode().getName());
		// assert endstate
		assertTrue(pi.hasEnded());
	}
}
