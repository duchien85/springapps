package com.springtest.springObjects;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	private static Logger logger = Logger.getLogger("LoggingAspect: ");

	@AfterReturning("execution(* com.springtest.model.*.*(..))")
	public void AfterAdvice(JoinPoint jp) {
		logger.debug("********AFTER*********");
		logger.debug("Target: " + jp.getTarget().getClass().getSimpleName());
		logger.debug("This: " + jp.getThis().getClass().getSimpleName());
	}

	@AfterThrowing(pointcut = "execution(* com.springtest.model.*.*(..))", throwing = "e")
	public void AfterThrowing(JoinPoint jp, Throwable e) {
		logger.debug("********AFTER THROWING*********");
		logger.debug("Target: " + jp.getTarget().getClass().getSimpleName());
		logger.debug("This: " + jp.getThis().getClass().getSimpleName());
		logger.debug(ExceptionUtils.getRootCauseMessage(e));
	}

	@Around("execution(* com.springtest.model.*.*(..))")
	public Object AroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		logger.debug("********AROUND BEFORE*********");
		logger.debug("Target: " + jp.getTarget().getClass().getSimpleName());
		logger.debug("This: " + jp.getThis().getClass().getSimpleName());

		try {
			return jp.proceed();
		}
		catch (Exception e) {
			logger.debug("Caught Exception...Throwing");
			throw e;
		}
	}

	@Before("execution(* com.springtest.model.*.*(..))")
	public void BeforeAdvice(JoinPoint jp) {
		logger.debug("********BEFORE*********");
		logger.debug("Target: " + jp.getTarget().getClass().getSimpleName());
		logger.debug("This: " + jp.getThis().getClass().getSimpleName());
	}
}
