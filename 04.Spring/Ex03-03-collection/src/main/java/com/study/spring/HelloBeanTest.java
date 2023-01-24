package com.study.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:beans.xml";
		
		// 1.Ioc �����̳� ����
		ApplicationContext context = new GenericXmlApplicationContext(configLocation);

		// 2. Helo Bean ��������
		Hello hello = (Hello)context.getBean("hello");
		
		// List ���
		List<String> myList = hello.getNames();
		for (String value : myList) {
			System.out.println("List : " + value);
		}
		
		// Set ���
		Set<Integer> mySet1 = hello.getNums();
		for (Integer value : mySet1) {
			System.out.println("Set : " + value);
		}
		
		// Map ���
		Map<String, Integer> map = hello.getAges();
		
		
		// ��� 01 : entrySet
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Map 1:" + entry.getKey() + " - " + entry.getValue());
		}
		
		// ��� 02 : keySet
		for(String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("Map 2: " + key + "-" + value);
		}
		
		
		// ��� 03 : Iterator
		Iterator<String> iterator = map.keySet().iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			System.out.println("Map 3: " + key + "-" + value);
		}
	}
}	
