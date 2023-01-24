package com.study.spring;


import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//	ASPECT : ������
//	ADVICE : �����ü - ����ð� ���
public class LogAop {
	
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
	
	
}
