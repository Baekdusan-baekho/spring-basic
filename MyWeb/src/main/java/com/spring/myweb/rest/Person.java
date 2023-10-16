package com.spring.myweb.rest;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Person {
	
	private String name;
	private int age;
	private List<String> hobby;
	
	// 자바 객체로는 json객체를 못 받는다.

}
