package com.spring.basic.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UserVO {

	
	private String userId;
	private String userPw;
	private String userName;
	private List<String> hobby;
	// 자바 규칙 
	//1.은닉 구현    2.기본 생성자 필수  3. getter에는 따로 매개변수가 존재하지 않아야 한다. 4. public으로 열려있어야 한다.        
	// 아이디와 비밀번호같이 2개만 받아도 된다 모든 객체 4개의 값을 쓸 필요는 없다
}
