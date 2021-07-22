package com.landisgyr.employeemangementsystem.repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTonDemo {

	public static void main(String[] args) {
//		Thread thread = new Thread(()->{EmployeeRepository employeeRepository = EmployeeRepositoryImpl.getInstance();});
//		Thread thread2 = new Thread(()->{EmployeeRepository employeeRepository = EmployeeRepositoryImpl.getInstance();});
//		
		try {
		//	EmployeeRepositoryImpl.getInstance();
			Class class1 = EmployeeRepositoryImpl.class;
			
			Constructor<?>[] constructor = class1.getDeclaredConstructors();
			constructor[0].setAccessible(false);
			
			Object employeeRepositoryImpl = constructor[0].newInstance();
			Object employeeRepositoryImpl2 = constructor[0].newInstance();
			
			//Constructor<EmployeeRepositoryImpl> constructor = EmployeeRepositoryImpl.class.getDeclaredConstructor();
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		thread.start();
//		thread2.start();
	}
}
