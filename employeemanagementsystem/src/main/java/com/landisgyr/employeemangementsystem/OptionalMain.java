package com.landisgyr.employeemangementsystem;

import java.util.List;
import java.util.Optional;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;
import com.landisgyr.employeemangementsystem.service.EmployeeService;
import com.landisgyr.employeemangementsystem.service.EmployeeServiceImpl;

public class OptionalMain {

	
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> optional = employeeService.getEmployees3().orElseThrow(()->new InvalidIdException("exception"));
		
		if(optional.isPresent()) {
			optional.get().forEach(System.out::println);
		}
	}
}
