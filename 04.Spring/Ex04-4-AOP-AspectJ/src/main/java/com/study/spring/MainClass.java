package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("classpath:beans.xml");	// »ý¼º
		
		
		Student student = context.getBean("student", Student.class);
		student.getStudentInfo();
		
		Worker worker = context.getBean("worker", Worker.class);
		worker.getWorkerInfo();
		
		 
		context.close();
		
	}
	
	
}
