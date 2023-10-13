package com.spring.myweb.freeboard.mapper;

import java.util.List;

import com.spring.myweb.freeboard.dto.page.Page;
import com.spring.myweb.freeboard.entity.FreeBoard;

public interface IFreeBoardMapper {

	// 글 등록
	void regist(FreeBoard freeBoard);
	
	// 글 목록
	List<FreeBoard> getList(Page page);
	
	// 총 게시물 개수 구하기
	int getTotal(Page page);
	
	// 상세보기
	FreeBoard getContent(int bno);
	
	// 수정
	void update(FreeBoard freeBoard);
	
	// 삭제
	void delete(int bno);
	
	
}

// FreeBOard.java에서 가져온 것들

// FreeBoard.java -> IFreeBoardMapper.java -> mappers에 FreeBoardMapper.xml생성


// xml과 관련있음 xml에서 사용하는 것들은 여기서 나감







