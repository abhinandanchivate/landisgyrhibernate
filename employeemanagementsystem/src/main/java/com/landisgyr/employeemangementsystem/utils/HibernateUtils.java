package com.landisgyr.employeemangementsystem.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.dto.Employee;

@Component
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory	 buildSessionFactory() {
	
		try {
			// by default it will look for hibernate.properties
			return new Configuration()
					.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class)
					.buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionFactory;
	}
	
	
	public  Session getSession() {
		return sessionFactory.openSession();
	}
	public  void closeSession(Session session) {
		session.close();
	}
	public  void closeSessionFactory() {
		sessionFactory.close();
	}
}
