package com.study.spring;


import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//	ASPECT : ������
//	ADVICE : �����ü - ����ð� ���
@Aspect
public class LogAop {
//	@Pointcut("execution(public void get*(..))")		// public void�� ��� get�޼ҵ�
//	@Pointcut("execution(* com.study.spring.*.*())")	// com.study.spring ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//	@Pointcut("execution(* com.study.spring..*.*())")	// com.study.spring ��Ű�� & com.study.spring ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
//	@Pointcut("execution(* com.study.spring.Worker.*())")	// com.study.spring.Worker ���� ��� �޼ҵ�

//	@Pointcut("within(com.study.spring.*)")			// com.study.spring ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//	@Pointcut("within(com.study.spring..*)")  		// com.study.spring ��Ű�� �� ���� ��Ű�� �ȿ� �ִ� ��� �޼ҵ�
//	@Pointcut("within(com.study.spring.Worker)") 	// com.study.spring.Worker ��� �޼ҵ�
	
//	@Pointcut("bean(student)")	// student �󿡸� ����
	@Pointcut("bean(*ker)")		// ~ker�� ������ �󿡸� ����
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
			System.out.println( signatureStr + " ����ð� : " + (et - st));
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
