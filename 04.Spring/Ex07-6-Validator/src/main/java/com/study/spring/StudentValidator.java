package com.study.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
// 폼에서 전달 되는 데이터를 커맨드 객체에 담아 
// 컨트롤 객체에 전달할 때 커맨드 "객체의 유효성 검사"를 할 수 있다.
// javascript을 이용하는 것은 클라이언트에서검사하는 방법
// Validator 인터페이스를이용하는 방법은 서버에 검사하는 방법	
	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);	// 검증할 객체의 클래스

	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble");
		}
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}
	}

}
