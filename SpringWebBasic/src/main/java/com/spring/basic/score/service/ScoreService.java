package com.spring.basic.score.service;

import org.springframework.stereotype.Service;

import com.spring.basic.score.dto.ScoreRequestDTO;

//컨트롤러와 레파지토리 사이의 배치되어 비즈니스 로직을 처리함
// 예) 값을 가공한다든지 예외 처리를 한다든지 
//DTO로 변환처리를 한다는지 트랜잭션을 한다든지 여러 잡일을 한다
@Service // 빈 등록, 컨트롤러와 다르지 않다
public class ScoreService {
	
	
	// 등록의 중간 처리
	public void insertScore(ScoreRequestDTO dto) {
		
	}
	
	
	

}









