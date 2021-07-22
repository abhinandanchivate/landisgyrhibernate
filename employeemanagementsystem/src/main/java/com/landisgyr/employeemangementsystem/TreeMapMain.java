package com.landisgyr.employeemangementsystem;

import java.util.TreeMap;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.utils.IdComparator;

public class TreeMapMain {

	public static void main(String[] args) {
		TreeMap<Employee, String> treeMap = new TreeMap<>(new IdComparator());
		treeMap.put(new Employee("ab002","abhi","chivate",200.0f), "abhi");
		treeMap.put(new Employee("ab001", "abhi","chivate",100.0f), "abhi");
//		treeMap.put(122, "abhi");
//		treeMap.put(10, "abhi");
		System.out.println(treeMap);
		
		treeMap.keySet().forEach(e->System.out.println(e));
		treeMap.descendingMap().forEach((k,v)->{
			System.out.println(k+"   "+v);
		});
		
		
		System.out.println(treeMap.get(new Employee("ab003", "abhi","chivate",100.0f)));
		
	}
}
