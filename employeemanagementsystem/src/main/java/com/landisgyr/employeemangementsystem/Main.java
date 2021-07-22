package com.landisgyr.employeemangementsystem;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;
import com.landisgyr.employeemangementsystem.service.EmployeeService;
import com.landisgyr.employeemangementsystem.service.EmployeeServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		
		
//		employee.setEmpId("ab001");
//		employee.setEmpFirstName("abhi");
//		employee.setEmpLastName("chivate");
		
//		String id  = employee.getEmpId();
//		String fName = employee.getEmpFirstName();
//		
//		System.out.println("id="+id); // ab001
//		System.out.println("firstName="+fName); // abhi
//		System.out.println(employee);
//		System.out.println(employee.toString());
		
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		for(int i =0;i<=10;i++) {
			Employee employee = null;
			try {
				employee = new Employee("ab001","abhi","chivate",123.0f,"bangalore","1234567890");
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// DC // can u accept the values @ the RT?
			
		String result = null;
		try {
			result = employeeService.addEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		}
		Employee[] employees = employeeService.getEmployees();
		// forEach
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
		
		Employee employee = employeeService.getEmployeeById("ab001");
		
		if(employee!=null) {
			System.out.println("Employee details"+employee);
		}
		else {
			System.out.println("Employee not found");
		}
		
	}

}
