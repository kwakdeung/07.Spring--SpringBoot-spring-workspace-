package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:beans.xml";
		
		// 1.Ioc 컨테이너 생성 - beans.xml 에 등록된 클래스를 생성
		ApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
		// 2.Hello Bean 가져오기 - 의존 주입(DI)받기
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		// 3.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);
		hello.print();
		// 4. 싱글톤인지 확인
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		
	//	context.close();

	}

}
