package com.landisgyr.employeemangementsystem.dto;

import lombok.Data;

@Data
public class EmployeeDeptDTO {
	private Department department = new Department();
	private Employee employee = new Employee();

}
