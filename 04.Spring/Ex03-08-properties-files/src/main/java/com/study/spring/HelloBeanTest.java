package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:beans.xml";
		
		// 1.IoC �����̳� ����
		ApplicationContext context = 
				new GenericXmlApplicationContext(configLocation);
		
		// 2.Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello");
		
		System.out.println(hello.getDriverClass());
		System.out.println(hello.getUrl());
		System.out.println(hello.getUsername());
		System.out.println(hello.getPassword());
		
		
		
	//	context.close();

	}

}
