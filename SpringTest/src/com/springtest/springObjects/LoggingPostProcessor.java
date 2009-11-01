package com.springtest.springObjects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LoggingPostProcessor implements BeanPostProcessor {
	final private static Logger logger = Logger.getLogger(LoggingPostProcessor.class);

	@Override
	public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
		logger.debug("processing after init: object of type: " + object.getClass().getName() + " / beanName: " + name);
		return object;
	}

	@Override
	public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
		logger.debug("processing before init: object of type: " + object.getClass().getName() + " / beanName: " + name);
		return object;
	}

}
