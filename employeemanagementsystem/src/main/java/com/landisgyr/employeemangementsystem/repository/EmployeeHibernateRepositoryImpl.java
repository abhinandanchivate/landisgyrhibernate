package com.landisgyr.employeemangementsystem.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;

import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.dto.EmployeeDeptDTO;
import com.landisgyr.employeemangementsystem.exception.InvalidIdException;
import com.landisgyr.employeemangementsystem.utils.HibernateUtils;

public class EmployeeHibernateRepositoryImpl implements EmployeeRepository {

	public static void main(String[] args) {
		EmployeeRepository employeeRepository = new EmployeeHibernateRepositoryImpl();
		System.out.println(employeeRepository.employeeCount());
		employeeRepository.employeeCountBasedOnLocation();
		//System.out.println(employeeRepository.addEmployee(new Employee("ab004","abhi","chivate",123.0f,"solapur","bangalore","9975477764","india")));
//		System.out.println(employeeRepository.getEmployeeById("ab001"));
//		Optional<List<Employee>> optional = employeeRepository.getEmployees3();
//		if(optional.isEmpty()) {
//			System.out.println("no record found");
//		}
//		else {
//			List<Employee> employees = optional.get();
//			employees.forEach(System.out::println);
//		}
		
		HibernateUtils.closeSessionFactory();
	}
	@Override
	public String addEmployee(Employee employee) throws InvalidIdException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			 session = HibernateUtils.getSession();
			session.beginTransaction();
			 Object object = session.save(employee);
			 System.out.println(object);
			if(object!=null) {
				session.getTransaction().commit();
			return "success";}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally {
			HibernateUtils.closeSession(session);
		}
		return "fail";
	}

	@Override
	public Employee[] getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getEmployees2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Employee>> getEmployees3() {
		// TODO Auto-generated method stub
		Session session  = HibernateUtils.getSession();
	//	String query = "select * from empl"; // SQL std(native query).
		String query = " FROM Employee";
		
		try {
			org.hibernate.query.Query<Employee> query2  =     session.createQuery(query);
			List<Employee> employees= query2.getResultList();
			
			if(employees.isEmpty()) {
				return Optional.empty();
			}
			else
			return Optional.of(employees);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			HibernateUtils.closeSession(session);
		}
	}

	@Override
	public Employee getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		String query = " From Employee WHERE empId=:empId";
		
		Session session = HibernateUtils.getSession();
		org.hibernate.query.Query<Employee> query2 = session.createQuery(query);
		query2.setParameter("empId", empId);
		Employee employee = query2.getSingleResult();
		
		
		return employee;
	}

	@Override
	public String deleteEmployeeById(String empId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		try {
			Employee employee = this.getEmployeeById(empId);
			if(employee!=null) {
			session.delete(employee);
			return "success";
			}
			else {
				return "record not found";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "problem";
		}
		finally {
			HibernateUtils.closeSession(session);
		}
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		// can u retrieve the existing object from the db based on the id?
		// can u compare those objects are not?
		// can u pass the same object details to update statement?
		// you have to find mismatch in objects(exsiting db and passed one)
		return null;
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		String deleteStatement = "delete from Employee";
		Session session = HibernateUtils.getSession();
		org.hibernate.query.Query<?> query  = session.createQuery(deleteStatement);
		int result = query.executeUpdate();
		System.out.println(result);
		
		if(result>0) {
			return "success";
		}
		else
		return "fail";
	}

	@Override
	public Optional<List<EmployeeDeptDTO>> getEmployeeDetailsWithDept() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long employeeCount() {
		// TODO Auto-generated method stub
		Session session = null ;
		long result = 0;
		try {
			String countQuery = " SELECT count(*) FROM Employee empl2";
			 session = HibernateUtils.getSession();
			org.hibernate.query.Query<Long> query = session.createQuery(countQuery);
			result = query.getFirstResult();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			HibernateUtils.closeSession(session);
		}
		
		return result;
	}
	@Override
	public List<Object[]> employeeCountBasedOnLocation() {
		// TODO Auto-generated method stub
		String queryStatement = "SELECT new Map(location, count(*)) from Employee group by location";
		Session session = HibernateUtils.getSession();
		List<Map<String, Long>> list2 = (List<Map<String, Long>>) session.createQuery(queryStatement).setResultTransformer(new Maptran);
		list2.forEach(System.out::println);
//		org.hibernate.query.Query<Object[]> query = session.createQuery(queryStatement);
//		List<Object[]> list = query.getResultList();
//		list.forEach(e->{for (Object object : e) {
//			System.out.println(object);
//		}});
		
	//	List<Map<String, Long>> list2 = query.getResultList().stream().map(null)
		return null;
	}

}
