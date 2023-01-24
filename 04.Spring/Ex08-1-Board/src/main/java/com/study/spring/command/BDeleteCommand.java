package com.study.spring.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;
import com.study.spring.controller.BController;

public class BDeleteCommand implements BCommand{
	@Override    
	public void execute(HttpServletRequest request, Model model) 
	{
		String bId = request.getParameter("bId");
		BDao dao = BDao.getInstance();
		dao.delete(bId);
	}
}
