package com.study.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:beans.xml";
		
		// 1.Ioc 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext(configLocation);

		// 2. Helo Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		
		// List 출력
		List<String> myList = hello.getNames();
		for (String value : myList) {
			System.out.println("List : " + value);
		}
		
		// Set 출력
		Set<Integer> mySet1 = hello.getNums();
		for (Integer value : mySet1) {
			System.out.println("Set : " + value);
		}
		
		// Map 출력
		Map<String, Integer> map = hello.getAges();
		
		
		// 방법 01 : entrySet
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Map 1:" + entry.getKey() + " - " + entry.getValue());
		}
		
		// 방법 02 : keySet
		for(String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("Map 2: " + key + "-" + value);
		}
		
		
		// 방법 03 : Iterator
		Iterator<String> iterator = map.keySet().iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			System.out.println("Map 3: " + key + "-" + value);
		}
	}
}	
