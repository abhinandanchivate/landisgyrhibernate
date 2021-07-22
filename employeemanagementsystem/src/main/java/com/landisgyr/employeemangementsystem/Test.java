package com.landisgyr.employeemangementsystem;

import com.landisgyr.employeemangementsystem.dto.Employee;

public class Test {

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		
		
		System.out.println(employee.equals(null)); // false
		System.out.println(employee.equals(employee2)); // false ==> because their 
		// object locations are different.
		System.out.println(employee.equals(employee)); // true ===> both will refer to same object
		
		
	}
}
