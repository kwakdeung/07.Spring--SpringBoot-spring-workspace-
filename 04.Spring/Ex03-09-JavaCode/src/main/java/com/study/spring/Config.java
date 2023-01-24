package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public Hello hello() {
		Hello hello1 = new Hello();
		hello1.setName("ȫ�浿");
		hello1.setNickname("����ġ");
		hello1.setPrinter(new PrinterA());
		
		return hello1;
	}
	
	@Bean(name="hello1")
	public Hello hello2() {
		return new Hello("ȫ�浿", "����ġ", new PrinterA());
	}
	
	@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	@Bean
	public PrinterB printerB() {
		return new PrinterB();
	}
}
