package com.landisgyr.employeemangementsystem.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class HelloWorld {
	
	private String value;
	private String value2;
	private int data;
	
	public HelloWorld(@Autowired Data data) {
		// TODO Auto-generated constructor stub
		System.out.println(data);
	}
	
//	public HelloWorld(String value, String value2) {
//		super();
//		this.value = value;
//		this.value2 = value2;
//		
//	}
//
//	public HelloWorld(String value, String value2, int data) {
//		super();
//		this.value = value;
//		this.value2 = value2;
//		this.data = data;
//	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		System.out.println("hello from setter method");
		this.value = value;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String sayHello() {
		return "hello";
	}
}


