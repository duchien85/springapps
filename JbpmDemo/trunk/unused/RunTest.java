package com.jbpmDemo.tests;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbpmDemo.service.PgpProblemService;

public class RunTest {
	private static PgpProblemService pgpProblemService;
	private static ProcessInstance processInstance;
	private static ProcessDefinition processDefinition;

	public static void main(String[] args) {
		try {
			AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
			context.registerShutdownHook();
			pgpProblemService = (PgpProblemService) context.getBean("pgpProblemService");
			processDefinition = pgpProblemService.createProcessDefinition("Test.xml");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}
}
