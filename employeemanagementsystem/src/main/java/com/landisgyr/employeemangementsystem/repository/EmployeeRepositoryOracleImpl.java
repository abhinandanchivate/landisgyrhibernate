package com.landisgyr.employeemangementsystem.repository;

import java.util.List;
import java.util.Optional;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.dto.EmployeeDeptDTO;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;

public class EmployeeRepositoryOracleImpl implements EmployeeRepository {

	@Override
	public String addEmployee(Employee employee) throws InvalidIdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee[] getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getEmployees2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<?> getEmployees3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return null;
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
	public Optional<List<EmployeeDeptDTO>> getEmployeeDetailsWithDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long employeeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object[]> employeeCountBasedOnLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
