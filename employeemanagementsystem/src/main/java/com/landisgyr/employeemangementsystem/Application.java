package com.landisgyr.employeemangementsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.landisgyr.employeemangementsystem.config.Config;
import com.landisgyr.employeemangementsystem.config.MySQLConfig;
import com.landisgyr.employeemangementsystem.dto.HelloWorld;
import com.landisgyr.employeemangementsystem.service.EmployeeService;
import com.landisgyr.employeemangementsystem.service.EmployeeServiceImpl;

public class Application {

	public static void main(String[] args) {
		//  
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		
		EmployeeService employeeService  = applicationContext.getBean("employeeService2",EmployeeService.class);
		EmployeeService employeeService2  = applicationContext.getBean("employeeService2",EmployeeService.class);
		System.out.println(employeeService.toString());
		System.out.println(employeeService2.toString());
		System.out.println(employeeService.equals(employeeService2));
//		System.out.println(applicationContext.getBean("myBean"));
		System.out.println(applicationContext.getBean(HelloWorld.class));
//		System.out.println(((HelloWorld)applicationContext.getBean("myBean")).getValue());
//		
	}
}
