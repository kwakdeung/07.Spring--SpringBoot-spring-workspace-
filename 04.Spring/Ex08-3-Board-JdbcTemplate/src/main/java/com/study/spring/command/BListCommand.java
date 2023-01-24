package com.study.spring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;
import com.study.spring.controller.BController;

@Component
public class BListCommand implements BCommand {
	
	@Override    
	public void execute(HttpServletRequest request, Model model) 
	{
		
		BDao dao = new BDao();
		
		
		ArrayList<BDto> dtos = dao.list(1);
		model.addAttribute("list", dtos);
		
		
	}

}
