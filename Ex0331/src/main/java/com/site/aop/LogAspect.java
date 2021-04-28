package com.site.aop;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.LoggerFactory;

public class LogAspect {
	
	Logger logger =  (Logger) LoggerFactory.getLogger(LogAspect.class);
	    
	    //Service의 모든 메서드
	    @Around("execution(* com.site.service.*(..))")
	    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
	        logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
	        Object result = pjp.proceed();
	        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
	        return result;
	    }

}
