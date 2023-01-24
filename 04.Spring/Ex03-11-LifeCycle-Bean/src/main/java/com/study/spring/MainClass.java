package com.study.spring;


import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	// 생성
		
		ctx.load("classpath:beans.xml");										// 설정
		System.out.println("aaaaa");
		ctx.refresh();
		System.out.println("bbbbb");
		
		
		
		
		ctx.close();															// 종료
		System.out.println("ccccc");
	}
	
	
}
