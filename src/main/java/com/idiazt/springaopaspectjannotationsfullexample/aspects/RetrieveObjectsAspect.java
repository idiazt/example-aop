package com.idiazt.springaopaspectjannotationsfullexample.aspects;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idiazt.springaopaspectjannotationsfullexample.aspects.annotations.LogObject;
import com.idiazt.springaopaspectjannotationsfullexample.aspects.annotations.LogObject.LogObjectLevel;
import com.idiazt.springaopaspectjannotationsfullexample.util.ReflectionUtil;

@Aspect
public class RetrieveObjectsAspect {

	private static Logger logger = LoggerFactory
			.getLogger(RetrieveObjectsAspect.class);

	@Pointcut("execution(@com.idiazt.springaopaspectjannotationsfullexample.aspects.annotations.LogObject * *.*(..))")
	public void logAnnotatedMethods() {
		// Extract from
		// https://eclipse.org/aspectj/doc/next/adk15notebook/ataspectj-pcadvice.html
		// As a general rule, the @Pointcut annotated method must have an empty
		// method body and must not have any throws clause. If formal are bound
		// (using args(), target(), this(), @args(), @target(), @this(),
		// @annotation()) in the pointcut, then they must appear in the method
		// signature.
	}

	@Before("logAnnotatedMethods()")
	public void executeBefore() {
		logger.info("Entering the aspect...");
	}

	@After("logAnnotatedMethods()")
	public void executeAfter() {
		logger.info("Leaving the aspect...");
	}

	@Around("logAnnotatedMethods()")
	public Object executeAround(ProceedingJoinPoint joinpoint) {
		try {
			Object result = joinpoint.proceed();
			Annotation annotation = ReflectionUtil
					.getAnnotationFromJoinpointMethod(joinpoint,
							LogObject.class);
			if (((LogObject) annotation).nivel().equals(LogObjectLevel.DEBUG))
				logger.info(result.toString());
			return result;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
