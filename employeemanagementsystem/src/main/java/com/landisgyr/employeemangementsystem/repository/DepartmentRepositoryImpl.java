package com.landisgyr.employeemangementsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.dto.Department;
import com.landisgyr.employeemangementsystem.utils.DBUtils;

public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Override
	public String addDepartment(Department department) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertQuery = "insert into Department (deptid, departname, location) values(?,?,?)";
		try {
			connection = DBUtils.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, department.getDepartmentId());
			preparedStatement.setString(2, department.getDepartmentName());
			preparedStatement.setString(3, department.getDepartmentLocation());
			
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
	public Department[] getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getDepartments2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getDepartments3() {
		// TODO Auto-generated method stub
				Connection connection = null;
				List<Department> Departments = new ArrayList<>();
				PreparedStatement preparedStatement = null;
				String insertQuery = "select * from Department";
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

						Department Department = new Department();
						Department.setDepartmentId(res.getString("Departmentid"));// column name
						// here we can provide the column number as well but we should prefer that.
						Department.setDepartmentName(res.getString("DepartmentName"));
						Department.setDepartmentLocation(res.getString("DepartmentLocation"));
						Departments.add(Department);

					}
					return Departments;

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
				return Departments;
	}

	@Override
	public Department getDepartmentById(String empId) {
		Connection connection = null;
		
		PreparedStatement preparedStatement = null;
		String insertQuery = "select * from Department where departmentId =" + empId;
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

				Department Department = new Department();
//				Department.setEmpId(res.getString("empid"));// column name
//				// here we can provide the column number as well but we should prefer that.
//				Department.setDepartmentName(res.getString("empfirstname"));
//				Department.setEmpLastName(res.getString("emplastname"));
//				Department.setEmpSalary(res.getFloat("empsalary"));
//				Departments.add(Department);

			}
			return null;

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
	public String deleteDepartmentById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(String empId, Department Department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
