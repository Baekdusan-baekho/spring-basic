package com.spring.myweb.snsboard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SnsModalRequestDTO {
	
	private int bno;
	private String content;
	private String writer;
	private String fileLoca;
	private String fileName;
	private String regDate;
}
