package com.spring.myweb.snsboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.myweb.snsboard.service.SnsBoardService;

import lombok.RequiredArgsConstructor;

@RestController // sns도 비동기 통신을 한다는 뜻 모든 메서드에 리스폰스바디가 달린 효과  
//modelandview가 없으면 jsp화면이 보이지 않는다.
@RequestMapping("/snsboard")
@RequiredArgsConstructor
public class SnsBoardController {
	
	private final SnsBoardService service;
	
	@GetMapping("/snsList")
	public ModelAndView snsList() { //void로는 화면이 백지로 나온다 에러는 아니지만 html이 나오지 않는다.
		ModelAndView mv = new ModelAndView();
		//mv.addObject("name", "value"); 데이터를 받을 때
		mv.setViewName("snsboard/snsList");
		return mv;
		
		
	}
	
	
	
}
