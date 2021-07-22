package com.landisgyr.employeemangementsystem.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Predicate;

import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.dto.Employee;
import com.landisgyr.employeemangementsystem.dto.EmployeeDeptDTO;
import com.landisgyr.employeemangementsystem.utils.DBUtils;
import com.landisgyr.employeemangementsystem.utils.IdComparator;

public class EmployeeRepositoryImpl implements EmployeeRepository , Serializable , Cloneable{

	// TreeSet<Employee> employees = new TreeSet<>(new IdComparator());

	public Object newInstance() throws CloneNotSupportedException  {
		
		throw new CloneNotSupportedException();
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	}
	
	private EmployeeRepositoryImpl() {
		// TODO Auto-generated constructor stub
		System.setSecurityManager(new SecurityManager());
		System.out.println("inside the constructor");
		if(employeeRepository!=null) {
			throw new InstantiationError();
		}
	
	}

	static EmployeeRepositoryImpl employeeRepository;

	public static EmployeeRepository getInstance() {
		

		if (employeeRepository == null) {
			synchronized (EmployeeRepositoryImpl.class) {
				if (employeeRepository == null) {
					System.out.println("method called");
					employeeRepository = new EmployeeRepositoryImpl();
					return employeeRepository;
				}
				else 
					return employeeRepository;
			}

		} 
		return employeeRepository;
	}

	public String addEmployee(Employee employee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = "insert into employee (empid,empfirstname,emplastname,empsalary) values(?,?,?,?)";
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setFloat(4, employee.getEmpSalary());
			int res = preparedStatement.executeUpdate();

			if (res >= 1) {
				connection.commit();
				return "success";
			} else
				return "fail";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			DBUtils.closeConnection(connection);
		}

		return "success";

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
		Connection connection = null;
		List<Employee> employees = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String insertQuery = "select * from employee";
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertQuery);

			ResultSet res = preparedStatement.executeQuery();
			// all records are stored in resultset obejct
			// cursor is available to traverse the result set .
			// initially cursor / traverser will be placed just before the 1st record.
			// when we will call next method for the 1st time then it will start traversing
			// from 1st record.

			while (res.next()) {

				Employee employee = new Employee();
				employee.setEmpId(res.getString("empid"));// column name
				// here we can provide the column number as well but we should prefer that.
				employee.setEmpFirstName(res.getString("empfirstname"));
				employee.setEmpLastName(res.getString("emplastname"));
				employee.setEmpSalary(res.getFloat("empsalary"));
				employees.add(employee);

			}
			if (employees.isEmpty())
				return Optional.empty();
			else
				return Optional.of(employees);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			DBUtils.closeConnection(connection);
		}
		return Optional.empty();

	}

	@Override
	public Employee getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(String empId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteQuery = "delete from employee where empid=?";
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, empId);
			int res = preparedStatement.executeUpdate();

			if (res >= 1) {
				connection.commit();
				return "success";
			} else
				return "fail";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			DBUtils.closeConnection(connection);
		}

		return null;
	}

	@Override
	public Employee updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<EmployeeDeptDTO>> getEmployeeDetailsWithDept() {
		Connection connection = null;
		List<EmployeeDeptDTO> employees = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String insertQuery = "select * from employee e , department d where e.deptid= d.deptid";
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertQuery);

			ResultSet res = preparedStatement.executeQuery();
			// all records are stored in resultset obejct
			// cursor is available to traverse the result set .
			// initially cursor / traverser will be placed just before the 1st record.
			// when we will call next method for the 1st time then it will start traversing
			// from 1st record.

			while (res.next()) {

				Employee employee = new Employee();
				Department department = new Department();
				EmployeeDeptDTO deptDTO = new EmployeeDeptDTO();

				employee.setEmpId(res.getString("empid"));// column name
				// here we can provide the column number as well but we should prefer that.
				employee.setEmpFirstName(res.getString("empfirstname"));
				employee.setEmpLastName(res.getString("emplastname"));
				employee.setEmpSalary(res.getFloat("empsalary"));
				deptDTO.setDepartment(department);
				deptDTO.setEmployee(employee);
				employees.add(deptDTO);

			}
			if (employees.isEmpty())
				return Optional.empty();
			else
				return Optional.of(employees);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

			DBUtils.closeConnection(connection);
		}
		return Optional.empty();

	}

	public List<Employee> getEmpsByJava8(Predicate<String> p) {
		return null;
	}
}
