package com.spring.myweb.freeboard.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.dto.page.PageCreator;
import com.spring.myweb.freeboard.dto.request.FreeModifyResponseDTO;
import com.spring.myweb.freeboard.dto.request.FreeRegistRequestDTO;
import com.spring.myweb.freeboard.service.IFreeBoardService;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/freeboard")
@RequiredArgsConstructor
public class FreeBoardController {

	private final IFreeBoardService service;
	
	// 페이징이 들어간 목록 화면
	@GetMapping("/freeList")
	public void freeList(Page page, Model model) {
		System.out.println("/freeboard/freeList: GET!");
		PageCreator creator;
		int totalCount = service.getTotal(page);
		if(totalCount == 0) {
			page.setKeyword(null);
			page.setCondition(null);
			creator = new PageCreator(page, service.getTotal(page));
			model.addAttribute("msg", "searchFail");
		} else {
			creator = new PageCreator(page, totalCount);			
		}
		
		model.addAttribute("boardList", service.getList(page));
		model.addAttribute("pc", creator);
	}
	
	// 글쓰기 페이지를 열어주는 메서드
	@GetMapping("/freeRegist")
	public void regist() {
//		return "freeboard/freeRegist";
	}
	
	
	//글 등록 처리
	@PostMapping("/freeRegist")
	public String regist(FreeRegistRequestDTO dto) {
		service.regist(dto);
		return "redirect:/freeboard/freeList";
	}
	
	// 글 상세 보기
	@GetMapping("/content")
	public String getContent(int bno,
				Model model,
				@ModelAttribute("p") Page page) {
		model.addAttribute("article", service.getContent(bno));
		return "freeboard/freeDetail";
	}
	
	// 글 수정 페이지 이동 요청 html
	@PostMapping("/modPage")
	public String modPage(@ModelAttribute("article") FreeModifyResponseDTO dto) {
		return "freeboard/freeModify";
	}
	
	// 글 수정 요청
	@PostMapping("/modify")
	public String modify(FreeModifyResponseDTO dto) {
		service.update(dto);
		return "redirect:/freeboard/content?bno=" + dto.getBno();
	}
	// model은 어떤 값을 넘겨줄 때 사용한다
	
	
	// 글 삭제 요청
	@PostMapping("/delete")
	public String delete(int bno) {
		service.delete(bno);
		return "redirect:/freeboard/freeList";
	}
	
}
