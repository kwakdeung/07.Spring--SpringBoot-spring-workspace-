package com.study.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();	// ����
		
		context.load("classpath:beans.xml");										// ����
		
		context.refresh();
		
		
		
		Student student = context.getBean("student", Student.class);				// ���
		System.out.println("�̸� : " + student.getName());
		System.out.println("���� : " + student.getAge());
		
		context.close();															// ����

	}
	
	
}
