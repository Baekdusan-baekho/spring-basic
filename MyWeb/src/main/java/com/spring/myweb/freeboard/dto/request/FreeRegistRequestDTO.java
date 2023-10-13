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
public class FreeRegistRequestDTO {
	
	private String title;
	private String content;
	private String writer;
	
	// 글 등록할 때 사용

}


