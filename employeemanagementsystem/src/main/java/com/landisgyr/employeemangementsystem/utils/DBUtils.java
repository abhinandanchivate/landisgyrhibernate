package com.landisgyr.employeemangementsystem.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBUtils {
	
//	public static void main(String[] args) {
//		try {
//			Connection connection =getConnection();
//			System.out.println(connection);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Properties properties = loadPropertyFIle();
		Connection connection = null;
		
		Class.forName(properties.getProperty("jdbc.driverName"));
		connection = DriverManager.getConnection
				(properties.getProperty("jdbc.url"),
						properties.getProperty("jdbc.username"), 
						properties.getProperty("jdbc.password"));
		return connection;
		
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties loadPropertyFIle() {
		
		try(InputStream inputStream  = new FileInputStream("application.properties")){
			Properties properties = new Properties();
			properties.load(inputStream);
			return properties;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
