package com.study.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	// 리디렉트(redirect: 키워드) - 다른 페이지로 이동할 때 사용한다.
	
	// studentConfirm으로 이동
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model){
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}
	// studentOk로 이동
	@RequestMapping("/studentOk")
	public String studentOk(Model model)
	{
		
		return "student:studentOk";
	}	
	// studentNg로 이동
	@RequestMapping("/studentNg")
	public String studentNg(Model model)
	{
		
		return "student:studentNg";
	}	
}
