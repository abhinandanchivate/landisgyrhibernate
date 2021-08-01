package com.landisgyr.employeemangementsystem;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.utils.HibernateUtils;

public class OneToManyMain {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		Transaction transaction =   session.beginTransaction();
		try {
			
			//transaction.begin();
			
			Department department  = new Department("dep009", "dev","bangalore");
			
			Employee employee = new Employee("ab004", "abhi", "chivate", 1000.0f, "solapur", "bangalore", "9975477764", "pune");
			employee.setDepartment(department);
			Employee employee2 = new Employee("ab005", "abhi", "chivate", 1000.0f, "solapur", "bangalore", "9975477764", "pune");
			employee2.setDepartment(department);
			Employee employee3 = new Employee("ab006", "abhi", "chivate", 1000.0f, "solapur", "bangalore", "9975477764", "pune");
			employee3.setDepartment(department);
			
			
			department.getEmployees().add(employee);
			
			
			
			session.persist(department);
//			session.flush();
//			String empId = employee.getEmpId();
//			System.out.println(empId);
//			session.clear();
//			Employee  employee2 = session.find(Employee.class, empId);
//			Department department2 = employee2.getDepartment();
			
//			department2.setDepartmentName("training");
//			employee2.setEmpFirstName("abhinandan");
			//session.detach(employee2);
			session.save(department);
			session.save(employee);
			session.save(employee2);
			//session.save(employee3);
			
			// 
			transaction.commit();
			
			HibernateUtils.closeSession(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			
		}
		
		
		
	}
}
