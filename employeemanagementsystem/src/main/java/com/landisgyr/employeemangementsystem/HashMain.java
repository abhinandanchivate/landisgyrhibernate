package com.landisgyr.employeemangementsystem;

import java.util.HashSet;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.service.EmployeeService;
import com.landisgyr.employeemangementsystem.service.EmployeeServiceImpl;

public class HashMain {
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public static void main(String[] args) {
		Employee employee = new Employee("ab001","abhi","chivate",123.0f);
		System.out.println(employee.hashCode());
		Employee employee2 = new Employee("ab002","abhi","chivate",123.0f);
		System.out.println(employee2.hashCode());
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		System.out.println(employeeService.addEmployee(employee2));
		System.out.println(employeeService.addEmployee(employee));
		System.out.println(employeeService.getEmployees3());
		
	}

}
