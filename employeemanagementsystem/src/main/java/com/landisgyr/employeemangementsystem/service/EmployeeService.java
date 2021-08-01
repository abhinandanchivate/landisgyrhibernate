package com.landisgyr.employeemangementsystem.service;

import java.util.List;
import java.util.Optional;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;

public interface EmployeeService {
	public String addEmployee(Employee employee) throws Exception;
	public Employee[] getEmployees() ;
	public Object[] getEmployees2() ;
	public Optional<?> getEmployees3() ;
	public Employee getEmployeeById(String empId) ;
	public String deleteEmployeeById(String empId);
	public Employee updateEmployee(String empId, Employee employee);
	
	public String deleteAllEmployees() ;
}
