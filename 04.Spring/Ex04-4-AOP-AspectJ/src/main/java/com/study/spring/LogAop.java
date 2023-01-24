package com.study.spring;


import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//	ASPECT : 공통기능
//	ADVICE : 기능자체 - 경과시간 출력
@Aspect
public class LogAop {
//	@Pointcut("execution(public void get*(..))")		// public void인 모든 get메소드
//	@Pointcut("execution(* com.study.spring.*.*())")	// com.study.spring 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* com.study.spring..*.*())")	// com.study.spring 패키지 & com.study.spring 하위 패키지에 파라미터가 없는 모든 메소드
//	@Pointcut("execution(* com.study.spring.Worker.*())")	// com.study.spring.Worker 안의 모든 메소드

//	@Pointcut("within(com.study.spring.*)")			// com.study.spring 패키지 안에 있는 모든 메소드
//	@Pointcut("within(com.study.spring..*)")  		// com.study.spring 패키지 및 하위 패키지 안에 있는 모든 메소드
//	@Pointcut("within(com.study.spring.Worker)") 	// com.study.spring.Worker 모든 메소드
	
//	@Pointcut("bean(student)")	// student 빈에만 적용
	@Pointcut("bean(*ker)")		// ~ker로 끝나는 빈에만 적용
	private void pointcutMethod() {}


	
	
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// TODO Auto-generated method stub
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}
		
	}
	
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	public void afterThrowingingAdvice() {
		System.out.println("afterThrowingingAdvice()");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
	
	
	
	
}
