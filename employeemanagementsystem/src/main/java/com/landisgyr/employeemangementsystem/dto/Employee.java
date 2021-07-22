package com.landisgyr.employeemangementsystem.dto;

import java.util.Objects;

import com.landisgyr.employeemangementsystem.exception.InvalidIdException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@ToString


// @Data
public class Employee {//implements Comparable<Employee> {//extends Person {
// all fields should be private except constants.
	private String empId;
	private String empFirstName;
	private String empLastName;
	
	protected float empSalary;
	private String permanantAddress;
	private String currentAddress;
	private String contactNumber;
	private String location;
	// parameterized constructor.// can we provide the values
	public Employee(String empId, String empFirstName, String empLastName, float empSalary, String permanantAddress,
			String contactNumber) throws InvalidIdException {
		this(empId, empFirstName, empLastName, empSalary);
		this.permanantAddress = permanantAddress;
		this.contactNumber = contactNumber;
	}
	public Employee() {
		//super("","");
		// TODO Auto-generated constructor stub
		System.out.println("hello from Employee");
	}
	public Employee(String empId, String empFirstName, String empLastName, float empSalary, String permanantAddress,
			String currentAddress, String contactNumber, String location) throws InvalidIdException {
//		super();
	this(empId, empFirstName, empLastName, empSalary);
		this.permanantAddress = permanantAddress;
		this.currentAddress = currentAddress;
		this.contactNumber = contactNumber;
		this.location = location;
	}
	public Employee(String empId, String empFirstName, String empLastName, float empSalary) throws InvalidIdException {
		//super(empFirstName,empLastName);
	this.setEmpId(empId);
		//super.setEmpFirstName(empFirstName);
		//super.setEmpLastName(empLastName);
		this.empSalary = empSalary;
	}

	public float calculateSalary() {
		return this.empSalary + 200;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId){
		if(empId.isEmpty()||empId.isBlank()) {
			throw new InvalidIdException("Id is blank or empty");
		}
		else
		this.empId = empId;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	public String getPermanantAddress() {
		return permanantAddress;
	}
	public void setPermanantAddress(String permanantAddress) {
		this.permanantAddress = permanantAddress;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
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
//	@Override
//	public int compareTo(Employee o) {
//		// TODO Auto-generated method stub
//		return this.empId.compareTo(o.empId);
//	}

	
	

	
}
