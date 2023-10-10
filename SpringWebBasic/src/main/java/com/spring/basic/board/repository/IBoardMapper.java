package com.spring.basic.board.repository;

import java.util.List;

import com.spring.basic.board.entity.Board;

public interface IBoardMapper {
	
	// 게시글 등록
	void insertArticle(Board board);
	
	// 게시글 목록
	List<Board> getArticles();
	
	// 게시글 상세
	Board getArticle(int bno);
	
	// 게시글 수정
	void updateArticle(Board board);
	
	// 게시글 삭제
	void deleteArticle(int bno);
	
	//sql 생각하면서 리턴 받나 어떤 것들이 필요한가 생각하면서 타입결정 
	//void인지 List인지 Board인지
	

}
