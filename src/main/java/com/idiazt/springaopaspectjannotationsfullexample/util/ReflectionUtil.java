package com.idiazt.springaopaspectjannotationsfullexample.util;

import java.lang.annotation.Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class ReflectionUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Annotation getAnnotationFromJoinpointMethod(
			ProceedingJoinPoint joinpoint, Class annotationClass)
			throws SecurityException, NoSuchMethodException {
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		String methodName = signature.getMethod().getName();
		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
		Annotation annotation = joinpoint.getTarget().getClass()
				.getMethod(methodName, parameterTypes)
				.getAnnotation(annotationClass);
		return annotation;
	}
}
