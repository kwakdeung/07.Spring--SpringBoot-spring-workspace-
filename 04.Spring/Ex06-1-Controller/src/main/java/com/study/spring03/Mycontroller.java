package com.study.spring03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mycontroller { // @Controller를 이용한 클래스 생성

	@RequestMapping("/board/view") // @RequestMapping을 이용한 요청 경로 지정
	public String view() { // 요청 처리 메소드 구현
		return "board/view"; // 뷰 이름 리턴
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) {
		
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	@RequestMapping("board/reply")
	public ModelAndView reply() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		mv.setViewName("board/reply");
		
		return mv;
	}

}
