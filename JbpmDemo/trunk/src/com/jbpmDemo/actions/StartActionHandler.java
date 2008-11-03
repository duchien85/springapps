package com.jbpmDemo.actions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class StartActionHandler implements ActionHandler {
	Logger logger = Logger.getLogger(StartActionHandler.class);

	@Override
	public void execute(ExecutionContext context) throws Exception {
		String variable = RandomStringUtils.randomAscii(20);
		logger.debug("setting stringVariable: " + variable);
		context.getContextInstance().setVariable("stringVariable", variable);

	}

}
