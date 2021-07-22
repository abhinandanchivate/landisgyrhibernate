package com.landisgyr.employeemangementsystem;

public class ExceptionMain {
	
	public static int div(int a, int b) {
		int c  = 0;
		try {
			c = a/b; /// AE object JVM ===> JVM will owe the responsibility to
			// prepare the predefined Exception & child objects
			// User defined one then we have to throw them manuallly.
			
			String s = null;
			s.charAt(0);// NPE : Nullpointerexception
			return c ;
		}
		catch(ArithmeticException ae) {
			System.out.println("exception occured");
		}
		catch (NullPointerException e) {
			System.out.println("NPE");
			// TODO: handle exception
		}
	
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception handled");
		}
		
		catch (Throwable e) {
			// TODO: handle exception
		}
		
//		catch (Object e) {
//			// TODO: handle exception
//		}
		
	
		finally {System.out.println("after div"); 
		}
		return c;
	}
	
	public static void main(String[] args) {
		
		System.out.println(div(100,20));
//		try {
//			int a = 10/0;
//			System.out.println(a);
//		}
//
//		catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			System.out.println("exception caught");
//		}
//		finally {
//		System.out.println("after catch block");
//	} }
	}
}
