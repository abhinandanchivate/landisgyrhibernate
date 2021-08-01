package com.landisgyr.employeemangementsystem.repository;

import java.util.List;
import java.util.Optional;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.dto.EmployeeDeptDTO;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;

public interface EmployeeRepository extends Cloneable{
	
	public String addEmployee(Employee employee) throws InvalidIdException;
	public Employee[] getEmployees() ;
	public Object[] getEmployees2() ;
	public Optional<?> getEmployees3() ;
	public Employee getEmployeeById(String empId) ;
	public String deleteEmployeeById(String empId);
	public Employee updateEmployee(String empId, Employee employee);
	
	public String deleteAllEmployees() ;
	public Optional<List<EmployeeDeptDTO>> getEmployeeDetailsWithDept();
	public long employeeCount();
	public List<Object[]> employeeCountBasedOnLocation();
	

}
