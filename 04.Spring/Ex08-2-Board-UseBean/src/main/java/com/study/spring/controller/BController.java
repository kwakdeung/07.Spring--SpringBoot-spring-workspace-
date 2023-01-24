package com.study.spring.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.command.BWriteCommand;

@Controller
public class BController {
	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
	
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list()");
//		command = new BListCommand();
		command = context.getBean(BListCommand.class);
		command.execute(request, model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(request, model);
		
		return "content_view";
	}
	@RequestMapping("/content")
	public String content(HttpServletRequest request, Model model) {
		System.out.println("content()");
		command = new BContentCommand();
		command.execute(request, model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("modify_view()");
		command = new BContentCommand();
		command.execute(request, model);
		
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		//command = new BModifyCommand();
		command = (BModifyCommand)context.getBean("modifyHandler");
		command.execute(request, model);
		
		command = new BContentCommand();
		command.execute(request, model);
		return "content_view";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		//command = new BReplyViewCommand();
		command = (BReplyViewCommand)context.getBean("replyViewHandler");
		command.execute(request, model);
		
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		//command = new BReplyCommand();
		command = (BReplyCommand)context.getBean("replyHandler");
		command.execute(request, model);
		
		command = new BContentCommand();
		command.execute(request, model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(HttpServletRequest request, Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
//		command = new BWriteCommand();
		command = (BWriteCommand)context.getBean("writeHandler");
		command.execute(request ,model);
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BListCommand();
		command = (BListCommand)context.getBean("deleteHandler");
		command.execute(request ,model);
		
		return "redirect:list";
	}
}
