package com.landisgyr.employeemangementsystem.dto;

import lombok.Data;

// when we will mark a class with @Data annotation then 
// by default it will generate 
// setters & getters
// it will override : hashcode, equals toString.

@Data
public abstract class Person {
	// it will extend to Object class ===> Object is super class for all.
	// if any class is not extending to someother class then by default 
	// it will extend to Object class.

	// we can delcare 0 to N abstract methods.
	// we can have abstract(non concrete ) methods + concrete methods.
	// we can declare N nos of concrete methods.
	// we can declare the variable or ref. we can declare===> multiple
	// can we declare the constructor?===> 
	// if yes : why: to initialize the field 
	// if No : why
	
	// which type of constrcutors we can use?
	// DC & PC
	
	// if a class is extending an abstract class then it must override all the 
	// abstract methods or declare that class as an abstract class.
	
	private String empFirstName;
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public Person(String empFirstName, String empLastName) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		
		
	}
	private String empLastName;
	
	public abstract String getDetails();
}
