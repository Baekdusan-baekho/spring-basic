package com.spring.basic.board.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardModifyRequestDTO {
	
	private int boardNo;
	private String writer;
	private String title;
	private String content;
	
	// 수정날짜 따로 추가 가능
	// 수정된 글에는 수정됨이라는 알림을 추가하던가 여러가지 추가 가능

}
