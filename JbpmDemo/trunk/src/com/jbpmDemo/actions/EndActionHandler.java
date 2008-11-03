package com.jbpmDemo.actions;

import org.apache.log4j.Logger;
import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class EndActionHandler implements ActionHandler {

	Logger logger = Logger.getLogger(EndActionHandler.class);

	@Override
	public void execute(ExecutionContext context) throws Exception {
		logger.debug("executing startActionHandler");
		String variable = (String) context.getContextInstance().getVariable("stringVariable");
		logger.debug("Got stringVariable: " + variable);
	}

}
