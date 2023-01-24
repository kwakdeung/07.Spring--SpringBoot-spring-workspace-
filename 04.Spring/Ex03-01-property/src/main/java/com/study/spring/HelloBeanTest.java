package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:beans.xml";
		
		// 1.Ioc �����̳� ���� - beans.xml �� ��ϵ� Ŭ������ ����
		ApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
		// 2.Hello Bean �������� - ���� ����(DI)�ޱ�
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		// 3.PrinterB Bean ��������
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);
		hello.print();
		// 4. �̱������� Ȯ��
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		
	//	context.close();

	}

}
