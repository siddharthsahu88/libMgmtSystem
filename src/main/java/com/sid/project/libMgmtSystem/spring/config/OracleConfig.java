package com.sid.project.libMgmtSystem.spring.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class OracleConfig {

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.url}")
	private String url;

	@Bean
	public DataSource dataSource() throws SQLException {

		OracleDataSource ods = new OracleDataSource();

		ods.setUser(username);
		ods.setPassword(password);
		ods.setURL(url);

		return ods;

	}

}
