package com.study.spring.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;

@Component("replyViewHandler")
public class BReplyViewCommand implements BCommand {

	@Override    
	public void execute(HttpServletRequest request, Model model) 
	{
		
		String bId = request.getParameter("bId");
		BDao dao = BDao.getInstance();
		BDto dto = dao.reply_view(bId);
		
		model.addAttribute("reply_view", dto);
	}
}
