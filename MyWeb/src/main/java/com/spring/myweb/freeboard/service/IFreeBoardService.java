package com.spring.myweb.freeboard.service;

import java.util.List;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.dto.request.FreeModifyResponseDTO;
import com.spring.myweb.freeboard.dto.request.FreeRegistRequestDTO;
import com.spring.myweb.freeboard.dto.response.FreeDetailResponseDTO;
import com.spring.myweb.freeboard.dto.response.FreeListResponseDTO;

public interface IFreeBoardService {
	
	// 글 등록
	void regist(FreeRegistRequestDTO dto);
		
	// 글 목록
	List<FreeListResponseDTO> getList(Page page);// import 단축키 컨트롤 쉬프트 알파벳 o
	
	// 총 게시물
	int getTotal(Page page);
		
	// 상세보기
	FreeDetailResponseDTO getContent(int bno);
		
	// 수정
	void update(FreeModifyResponseDTO freeboard);
		
	// 삭제
	void delete(int bno);
	
	// dto에서 가져온 것들
	
	
	// FreeBoardController.java 에서 사용하는 것들은 여기서 나감
	
	// jsp -> FreeBoardController -> IFreeBoardService.
	
	
	//  FreeBoardService 가 여기 IFreeBoardService를 가져감 implements IFreeBoardService
	
	//IFreeBoardService 와 IFreeBoardMapper의 연관성은 사이에 FreeBoardService가 있다 

}
