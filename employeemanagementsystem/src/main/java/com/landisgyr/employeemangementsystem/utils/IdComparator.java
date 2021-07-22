package com.landisgyr.employeemangementsystem.utils;

import java.util.Comparator;

import com.landisgyr.employeemangementsystem.dto.Employee;

public class IdComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmpId().compareTo(o2.getEmpId());
	}

}
