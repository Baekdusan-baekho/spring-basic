package com.spring.myweb.freeboard.dto.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FreeModifyResponseDTO {
	
	private int bno;
	private String writer;
	private String title;
	private String content;
	
	// 글 수정할 때 사용
	

}
