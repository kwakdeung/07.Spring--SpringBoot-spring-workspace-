package com.study.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Lombok";
	}
	
	@RequestMapping("/test1")	// localhost:8081/test1
	public String test1(Member member, Model model) {
		System.out.println(member);
		return "test1";			// 실제 호출 될 /WEB-INF/views/test1.jsp
	}
	
}
