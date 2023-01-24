package com.study.spring;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.dao.ContentDao;
import com.study.spring.dao.IDao;
import com.study.spring.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	ContentDao dao;
	@Autowired // 내가 만든 것이 아니다. 요청한다.
	private SqlSession sqlSession;
	
//	@Autowired
//	public void setDao(ContentDao dao) {
//		this.dao = dao;
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ArrayList<ContentDto> dtos = dao.listDao();
		IDao dao = sqlSession.getMapper(IDao.class);
//		ArrayList<ContentDto> dtos = dao.listDao();
		model.addAttribute("list", dao.listDao());
		
		int nTotalCount = dao.articleCount();
		System.out.println("Count : " + nTotalCount);
		
		return "/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		String bName = request.getParameter("mWriter");
		String bContent = request.getParameter("mContent");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", bName);
		map.put("item2", bContent);
		
		int nResult = sqlSession.update("writeDao", map);
		System.out.println("Write : " + nResult);
		
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view() {
		
		return "/view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.deleteDao(request.getParameter("mId"));
		
		String bid = request.getParameter("mId");
		int nResult = sqlSession.update("deleteDao", bid);
		System.out.println("Delete : " + nResult);
		
		return "redirect:list";
	}
}
