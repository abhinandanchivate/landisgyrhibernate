package com.landisgyr.employeemangementsystem.repository;

import java.util.List;

import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;



public interface DepartmentRepository {
	
	public String addDepartment(Department Department) throws InvalidIdException;
	public Department[] getDepartments() ;
	public Object[] getDepartments2() ;
	public List<Department> getDepartments3() ;
	public Department getDepartmentById(String empId) ;
	public String deleteDepartmentById(String empId);
	public Department updateDepartment(String empId, Department Department);
	
	public String deleteAllDepartments() ;

}
