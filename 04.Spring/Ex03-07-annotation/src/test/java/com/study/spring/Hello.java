package com.study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// �˻��� Ŭ������ ������ ����� ��, Ŭ������ ù ���ڸ� �ҹ��ڷ� �ٲ�
// �̸��� ���� �̸����� ����Ѵ�.
@Component
public class Hello {
	
	@Value("ȫ�浿")
	private String name;
	@Value("����ġ")
	private String nickname;
	@Autowired	// �ڵ� ����
	@Qualifier("printerA") // �ڵ� ���� ������ ���� �� �� �̻��� �� Ư���� �� �� �����ϱ�
	private Printer printer;
	
	public Hello() {}; // ����Ʈ ������ �߰�

	public Hello(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	// Setter�޼��尡 ��� �ȴ�.

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public String sayHello() {
		return "hello " + name + " : " + nickname;
	}
	public void print() {
		printer.print(sayHello());
	}
	
	
}
