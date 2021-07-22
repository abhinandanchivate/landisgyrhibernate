package com.landisgyr.employeemangementsystem.dto;

import com.landisgyr.employeemangementsystem.Manager;

public class InheritanceMain1 {

	public static final float PI=3.14f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee manager = new Manager("ab002","abhi","chivate",1000.0f,"solapur","bangalore",
				"1234567890","bangalore","training",100.0f	); // employee
		
		Manager manager2 = new Manager("ab002","abhi","chivate",1000.0f,"solapur","bangalore",
				"1234567890","bangalore","training",100.0f	); // manager
		
		System.out.println(manager.calculateSalary());
		System.out.println(manager2.getProjectAllowance());
		System.out.println(manager2.getProjectName());
	}

}
