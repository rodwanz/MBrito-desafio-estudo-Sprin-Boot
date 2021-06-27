package com.eventosapp.data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//@Profile("dev")
public class DataConfiguration {
	
	@Bean
	public DataSource mysqlDataSource() {

	    DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp?useTimezone=true&serverTimezone=UTC");
	    dataSource.setUsername("root");
	    dataSource.setPassword("miguel");

	    return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	    final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.MYSQL);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(true);
	    adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");	    
	    //adapter.setPrepareConnection(true);
	    return adapter;
	}

}
