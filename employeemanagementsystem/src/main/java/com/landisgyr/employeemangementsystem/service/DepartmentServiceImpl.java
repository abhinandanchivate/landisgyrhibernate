package com.landisgyr.employeemangementsystem.service;

import java.util.List;

import com.landisgyr.Departmentmangementsystem.dto.Department;
import com.landisgyr.Departmentmangementsystem.repository.DepartmentRepository;
import com.landisgyr.Departmentmangementsystem.exception.InvalidIdException;

public class DepartmentServiceImpl implements DepartmentService {
	DepartmentRepository DepartmentRepository  = new DepartmentRepositoryImpl();
	
	public String addDepartment(Department Department) throws InvalidIdException {
		// background verification
		// criminal cross check 
		// address verification
		
		return DepartmentRepository.addDepartment(Department);
	}
	
	public Department[] getDepartments() {
		return DepartmentRepository.getDepartments();
	}
	
	public Department getDepartmentById(String empId) {
		return DepartmentRepository.getDepartmentById(empId);
	}

	@Override
	public String deleteDepartmentById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(String empId, Department Department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getDepartments2() {
		// TODO Auto-generated method stub
		return DepartmentRepository.getDepartments2();
	}

	@Override
	public List<Department> getDepartments3() {
		// TODO Auto-generated method stub
		return DepartmentRepository.getDepartments3();
	}
}


}
