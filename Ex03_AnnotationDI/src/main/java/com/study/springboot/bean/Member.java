package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 검색된 클래스를 빈으로 등록할 때, 클래스의 첫 글자를 소문자로 바꾼
// 이름을 빈의 이름으로 사용한다.
@Component
public class Member {
	@Value("홍길동")
	private String name;
	@Value("도사")
	private String nickname;
	@Autowired
	@Qualifier("printerA")
	private Printer printer;
	
	public Member() {}
	
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void print() {
		printer.print("Hello " + name + " : " + nickname);

	}

}
