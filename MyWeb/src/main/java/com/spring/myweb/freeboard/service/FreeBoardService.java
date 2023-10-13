package com.spring.myweb.freeboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.dto.request.FreeModifyResponseDTO;
import com.spring.myweb.freeboard.dto.request.FreeRegistRequestDTO;
import com.spring.myweb.freeboard.dto.response.FreeDetailResponseDTO;
import com.spring.myweb.freeboard.dto.response.FreeListResponseDTO;
import com.spring.myweb.freeboard.entity.FreeBoard;
import com.spring.myweb.freeboard.mapper.IFreeBoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreeBoardService implements IFreeBoardService {
	
	private final IFreeBoardMapper mapper;
	
	@Override
	public void regist(FreeRegistRequestDTO dto) {
		mapper.regist(FreeBoard.builder()
								.title(dto.getTitle())
								.content(dto.getContent())
								.writer(dto.getWriter())
								.build());
	}

	@Override
	public List<FreeListResponseDTO> getList(Page page) {
		List<FreeListResponseDTO> dtoList = new ArrayList<>();
		List<FreeBoard> list = mapper.getList(page);
		for(FreeBoard board : list) {
			dtoList.add(new FreeListResponseDTO(board));
		}	
		return dtoList;
		
	}
	
	@Override
	public int getTotal(Page page) {
		return mapper.getTotal(page); // IFreeBoardMapper
	}

	@Override
	public FreeDetailResponseDTO getContent(int bno) { // FreeDetailResponseDTO새로 만들어서 사용함
		return new FreeDetailResponseDTO(mapper.getContent(bno)); // freeboardmapper.xml에서 sql 코드가 돌아감
	}

	@Override
	public void update(FreeModifyResponseDTO freeBoard) {
		mapper.update(FreeBoard.builder()
								.title(freeBoard.getTitle())
								.content(freeBoard.getContent())
								.bno(freeBoard.getBno())
								.build());

	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);

	}
	
	// IFreeBoardMapper을 가져와서
	// IFreeBoardMapper 는 DTO를 사용함
	// IFreeBoardMapper 는 FreeBoardController와 연관이 있음
	
	// IFreeBoardMapper 에서 gettotal 가져옴
	// IFreeBoardMapper 에서 getlist 가져옴
	// IFreeBoardMapper 에서 getcontent 가져옴
	
	
	
	//implements IFreeBoardServic 가져옴 @override
	// DTO 를 매개변수로 가져옴
	//  IFreeBoardMapper 에서 생성자 가져옴
	// page.java에서 생성자 가져옴
	
	
	// IFreeBoardService.java
	//@Override
	//public int getTotal(Page page) 매개변수는 DTO 사용함 
	
	
	// IFreeBoardMapper  
	// mapper.update
	// FreeBoard.java 생성자 가져옴
	// page.java 데이터도 가져옴 페이지 수 
	
	
	// 
	
	
	
	
}
