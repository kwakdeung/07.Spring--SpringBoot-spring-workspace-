package com.study.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Member;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dao.SimpleBbsDao;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public String root() throws Exception{
		// JdbcTemplate : SimpleBBS
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		model.addAttribute("list", dao.listDao());
		return "/list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest requset, Model model) {
		String sId = requset.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));
		return "/view";
	}	
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest requset, Model model) {
		dao.writeDao(requset.getParameter("writer"),
					requset.getParameter("title"),
					requset.getParameter("content"));
		return "redirect:list";
	}	
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest requset, Model model) {
		dao.deleteDao(requset.getParameter("id"));
		return "redirect:list";
	}	

}
