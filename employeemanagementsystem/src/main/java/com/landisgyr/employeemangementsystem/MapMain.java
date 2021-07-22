package com.landisgyr.employeemangementsystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.landisgyr.employeemangementsystem.dto.Employee;

public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
		
		hashMap.put(1, "abhi");
		hashMap.put(200, "abhinandan");
		hashMap.put(null, "abhi");
		System.out.println(hashMap);
		hashMap.put(1, null);
		hashMap.put(null, null);
	//	System.out.println(hashMap);
		System.out.println(hashMap.toString());
		
		hashMap.forEach((k,v)->{
			System.out.println(k +"  "+v);
		});
		
		//hashMap.forEach(null);
		
		Set<Entry<Integer, String>> set = hashMap.entrySet();
		
		set.forEach(e->{System.out.println(e.getValue());});
		
		Set<Entry<Integer, String>> set2 =hashMap.entrySet();
		
		Iterator<Entry<Integer, String>> iterator  = set2.iterator();
		
		while (iterator.hasNext()) {
			
			Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() +"  "+entry.getValue());
			
		}
		
		boolean status = hashMap.containsKey(1);
		System.out.println(status);
		
		status = hashMap.containsValue("abhi");
		System.out.println(status);
		
	}

}
