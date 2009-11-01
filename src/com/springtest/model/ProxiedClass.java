package com.springtest.model;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;

public class ProxiedClass {

	protected static Logger logger = Logger.getLogger(ProxiedClass.class);
	int x;

	public void method1() {
		logger.debug("Base class doing method 1");
	}

	public void method2() {
		logger.debug("Base class doing method2");
		if (RandomUtils.nextBoolean()) {
			throw new RuntimeException("Some random exception");
		}
	}

	@PostConstruct
	public void postConstruct() {
		logger.debug("PostConstruct");
		x = 1;
	}

	@SuppressWarnings("unused")
	private void privateMethod() {
		logger.debug("Private Method");
	}

	protected void protectedMethod() {
		logger.debug("Protected Method");
	}
}
