package com.site.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.site.aop.LogAspect;

@Component
@Aspect
public class LogAdvice {
	
	private static final Logger LOGGER = LogManager.getLogger(LogAdvice.class);


	@Around("within(com.site.controller.*)")
	public void LogCheck(ProceedingJoinPoint proceedingJoinPoint) {
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		System.out.println("type : "+type);
		System.out.println("method : "+method);
        LOGGER.info("Hello Info level log : "+method);

	}
}
