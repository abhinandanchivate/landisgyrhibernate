package com.landisgyr.employeemangementsystem.service;

import java.util.List;
import java.util.Optional;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;
import com.landisgyr.employeemangementsystem.repository.EmployeeRepository;
import com.landisgyr.employeemangementsystem.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository  = EmployeeRepositoryImpl.getInstance();
	// have we created repo object.
	public String addEmployee(Employee employee) throws InvalidIdException {
		// background verification
		// criminal cross check 
		// address verification
		
		return employeeRepository.addEmployee(employee);
	}
	
	public Employee[] getEmployees() {
		return employeeRepository.getEmployees();
	}
	
	public Employee getEmployeeById(String empId) {
		return employeeRepository.getEmployeeById(empId);
	}

	@Override
	public String deleteEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getEmployees2() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployees2();
	}

	@Override
	public Optional<List<Employee>> getEmployees3() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployees3();
	}
}
