package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ������ ������ Ŭ�����н� ��Ʈ�� �ƴ� �ٸ� ���� ��ġ�Ѵ�.
		//	  ��Ʈ�� �������� ��� ������ �Է�
//		String configLocation = "classpath:config/beans.xml";
//		String configLocation = "classpath:/config/beans.xml";
		
		// 2. Ŭ�����н��� �ƴ� ���� �ý��ۿ��� ���� ������ �о� ����
//		String configLocation = "file:src/main/resources/config/beans.xml";
		
		// 3. Ư�� ��ο� �ִ� ��� xml ������ ���� ���Ϸ� ����ϰ� ���� ���
//		String configLocation = "classpath:config/beans*.xml";		
		
		// 4.IoC �����̳� ����
//		ApplicationContext context = new GenericXmlApplicationContext(configLocation);
		
		// 4. 1�� �̻��� ���� ���� ��θ� ������ ���� ���� : ���� ���� ������
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:beans.xml",
				"classpath:config/beans2.xml");
		
		// B.Hello Bean ��������
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
	
//		context.close();
	
	}

}
