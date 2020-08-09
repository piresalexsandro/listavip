package br.com.alphapires.utils;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BancoDados {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource  =  new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setUsername("alpires");
		dataSource.setPassword("@alp1809");
		return dataSource();
	}
}
