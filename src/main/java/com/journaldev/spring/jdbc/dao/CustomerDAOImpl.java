package com.journaldev.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.journaldev.spring.jdbc.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public void create(Customer customer) {
	
		String queryCustomer = "insert into Customer (id, name) values (?,?)";
		String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(queryAddress, new Object[]{customer.getAddress().getId(),customer.getAddress().getAddress(),customer.getAddress().getCountry()});
		System.out.println("address recode has been inserted...");
		jdbcTemplate.update(queryCustomer,new Object[]{customer.getId(),customer.getName()});
		System.out.println("customer reocde has been inserted ...");
		
		
	}

	
}
