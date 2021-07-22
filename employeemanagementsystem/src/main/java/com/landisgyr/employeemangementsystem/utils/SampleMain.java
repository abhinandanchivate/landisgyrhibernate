package com.landisgyr.employeemangementsystem.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SampleMain {
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
			return numbers.parallelStream().filter(predicate).mapToInt(i->i).sum();
	}

	public static void main(String[] args) {
		
		Sample sample = (a,b)->a+b;
	//	System.out.println(sample.sum(10, 20));
		
		System.out.println(sumWithCondition(Arrays.asList(1,2,3,4,5,6,7,8,9,10), n->true));
		System.out.println(sumWithCondition(Arrays.asList(1,2,3,4,5,6,7,8,9,10), n->n%2==0));
		System.out.println(sumWithCondition(Arrays.asList(1,2,3,4,5,6,7,8,9,10), n->n>5));

		
		
		
		
	}
}
