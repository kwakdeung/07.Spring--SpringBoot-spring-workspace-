package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student,
								BindingResult result) {
		String page = "createDonePage";
		
		// Validator를 이용한 검증
		StudentValidator validator = new StudentValidator(); 
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}
		
		return page;
	}

}
