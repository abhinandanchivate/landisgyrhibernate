package com.landisgyr.employeemangementsystem.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;
import com.landisgyr.employeemangementsystem.repository.EmployeeRepository;
import com.landisgyr.employeemangementsystem.repository.EmployeeRepositoryImpl;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	
	EmployeeRepository employeeRepository;
	// have we created repo object.
	public String addEmployee(Employee employee) throws InvalidIdException {
		// background verification
		// criminal cross check 
		// address verification
		Connection  connection = null;
		
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
	public Optional<?> getEmployees3() {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployees3();
	}
}
