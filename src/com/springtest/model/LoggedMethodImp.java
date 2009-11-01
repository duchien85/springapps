package com.springtest.model;

import org.apache.log4j.Logger;

public class LoggedMethodImp implements LoggedMethodInterface {
	private final static Logger logger = Logger.getLogger(LoggedMethodImp.class);

	@Override
	public void loggedMethod1() {
		logger.debug("loggedMethod 1...");
	}

	@Override
	public void loggedMethod2() {
		logger.debug("loggedMethod 2...");
	}

}
