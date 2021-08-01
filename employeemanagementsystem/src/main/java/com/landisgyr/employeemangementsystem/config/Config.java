package com.landisgyr.employeemangementsystem.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.landisgyr.employeemangementsystem.dto.HelloWorld;

@Configuration
@ComponentScan("com.landisgyr.employeemangementsystem") // @Service @Repository @Cotroller @RestController

@PropertySource("classpath:data.properties")
@Import(MySQLConfig.class)
@ImportResource("spring.xml")

public class Config {
	
	@Autowired
	private Environment environment; // to get the property value.
	
	@Bean // if u will not provide the name then it will take method name as a bean name.
	@Scope("prototype")
	public DataSource getMySQLDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(environment.getProperty("db.driver"));
		return basicDataSource;
	}
	
	
}
