package com.study.spring.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;
import com.study.spring.controller.BController;



public class BWriteCommand implements BCommand {
	
	@Override    
	public void execute(HttpServletRequest request, Model model) 
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		BDao dao = BDao.getInstance();
		dao.write(bName, bTitle, bContent);
	}

}
