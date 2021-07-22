package com.landisgyr.employeemangementsystem;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.service.EmployeeService;
import com.landisgyr.employeemangementsystem.service.EmployeeServiceImpl;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		
		Employee employee = new Employee("ab001", "abhi", "chivate", 100.0f);
		Employee employee2 = new Employee("ab001", "abhi", "chivate", 100.0f);
		Employee employee3 = new Employee("ab001", "abhi", "chivate", 100.0f);
		
		String result = employeeService.addEmployee(employee3);
		System.out.println(result);
		result = employeeService.addEmployee(employee2);
		System.out.println(result);
		result = employeeService.addEmployee(employee);
		System.out.println(result);
		
		Employee[] employees = employeeService.getEmployees();
		for (Employee employee4 : employees) {
			System.out.println(employee4);
		}
		
		Object[] objects = employeeService.getEmployees2();
		
		for (Object object : objects) {
			System.out.println(((Employee)object).toString());
			System.out.println((Employee)object);
			// when u will print reference then it will call toString method.
		}
		
		employeeService.getEmployees3().forEach(e->System.out.println(e));
		for (Employee e : employeeService.getEmployees3()) {
			System.out.println(e);
		}
		
	

	}

}
