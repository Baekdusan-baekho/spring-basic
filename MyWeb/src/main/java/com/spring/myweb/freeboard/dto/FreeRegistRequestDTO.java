package com.spring.myweb.freeboard.dto;

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
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}


