package com.springtest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.model.LoggedMethodInterface;
import com.springtest.model.ProxiedClass;

public class SimpleMain {
	private static ClassPathXmlApplicationContext appContext;
	private static Logger logger = Logger.getLogger(SimpleMain.class);

	public static void main(String[] args) {
		createAppContext();
		doProxiedClass();
		doLoggedMethodImp();
	}

	private static void createAppContext() {
		logger.debug("Starting up app context");
		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	private static void doLoggedMethodImp() {
		LoggedMethodInterface lmi = (LoggedMethodInterface) appContext.getBean("loggedMethodImp");
		logger.debug("calling doLoggedMethodInterface methods");
		lmi.loggedMethod1();
		lmi.loggedMethod2();
	}

	private static void doProxiedClass() {
		ProxiedClass pc = (ProxiedClass) appContext.getBean("proxiedClass");
		logger.debug("calling proxiedClass methods");
		pc.method1();
		pc.method2();
	}

}
