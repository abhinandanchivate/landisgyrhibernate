package com.landisgyr.employeemangementsystem;

import com.landisgyr.employeemangementsystem.dto.Employee;

import lombok.Data;

@Data
public class Manager extends Employee  { 
	// Manager is-a type of employee.
	private String projectName;
	private float projectAllowance;
public Manager() {
	// TODO Auto-generated constructor stub
	// do we need to consume the PC from base class?
	// we have to use a super method.
	//super("ab002", "abhi", "chivate", 123.0f, "solapur", "1234567890");
	super();
	System.out.println("hello from Manager DC");
}

public Manager(String empId, String empFirstName, String empLastName, float empSalary, String permanantAddress,
		String currentAddress, String contactNumber, String location, String projectName, float projectAllowance) {
	super(empId, empFirstName, empLastName, empSalary, permanantAddress, currentAddress, contactNumber, location);
	this.projectName = projectName;
	this.projectAllowance = projectAllowance;
	System.out.println(super.empSalary);
	// TODO Auto-generated constructor stub
}

public Manager(String empId, String empFirstName, String empLastName, float empSalary, String permanantAddress,
		String contactNumber) {
	//super(empId, empFirstName, empLastName, empSalary, permanantAddress, contactNumber);
	// TODO Auto-generated constructor stub
	this(empId,empFirstName,empLastName,empSalary,permanantAddress,null,contactNumber,null,null,0.0f);
}

public Manager(String empId, String empFirstName, String empLastName, float empSalary) {
	super(empId, empFirstName, empLastName, empSalary);
	// TODO Auto-generated constructor stub
}

@Override
public float calculateSalary() {
	// TODO Auto-generated method stub
	return super.calculateSalary() + this.projectAllowance;
}

}
