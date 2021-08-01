package com.landisgyr.employeemangementsystem.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:data.properties")
public class MySQLConfig {
	
	@Value("${db.driver}")
	private String jdbcDriver;
	
	
	@Bean // if u will not provide the name then it will take method name as a bean name.
	public DataSource getMySQLDataSource2() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(jdbcDriver);
		return basicDataSource;
	}

}
