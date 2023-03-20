package com.app.profile.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {

	Logger logger = LoggerFactory.getLogger(AspectClass.class);

//	@Pointcut("@annotation(Log)")

//	@Pointcut("execution(public void com.app.profile.service.ServiceImpl.justPrint())")
//	@Pointcut("execution(* com.app.profile.service..*())")

	@Pointcut("within(com.app.profile.controller.*) || within(com.app.profile.service..*)")
//	@Pointcut("within(com.app.profile.service.ServiceImpl)")
	public void pointCutLog() {
	}

	@Before("pointCutLog()")
	public void adviceLog(JoinPoint joinPoint) {
		logger.info("Enter into " + joinPoint.getSignature().getName() + "() "
				+ joinPoint.getTarget().getClass().getSimpleName());
	}

	@After("pointCutLog()")
	public void adviceLogAfter(JoinPoint joinPoint) {
		logger.info("Exit from " + joinPoint.getSignature().getName() + "() "
				+ joinPoint.getTarget().getClass().getSimpleName());
	}

	@AfterThrowing(value = "pointCutLog()", throwing = "ex")
	public void printError(JoinPoint joinPoint, Exception ex) {
		logger.info("Exception in " + joinPoint.getSignature().getName() + "() "
				+ joinPoint.getTarget().getClass().getSimpleName());
//		System.out.println(ex);
		logger.error(ex.getMessage());
	}
}
