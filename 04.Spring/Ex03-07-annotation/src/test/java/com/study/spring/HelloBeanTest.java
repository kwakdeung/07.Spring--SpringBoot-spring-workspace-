package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new GenericXmlApplicationContext("classpath:beans.xml");
		
		// 2.Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
		// 3.PrinterB Bean ��������
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);
		hello.print();
		
		// 4.�̱������� Ȯ��
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		
		
		
	//	context.close();

	}

}
