package com.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.HibernateError;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.annotation.*;
import javax.sql.DataSource;

@Configuration
public class SpringCoreHibernateUtils 
{
	ResourceBundle rb = ResourceBundle.getBundle("resource");
	
	@Bean
	public DataSource dataSource() 
	{
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(rb.getString("jdbc.driver"));
		dataSource.setUrl(rb.getString("jdbc.url"));
		dataSource.setUsername(rb.getString("jdbc.username"));
		dataSource.setPassword(rb.getString("jdbc.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() 
	{
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan("com.pojos");
		// sessionFactory.setPackagesToScan(new String[] {
		// "com.baeldung.persistence.model" });
		return sessionFactory;
	}

	/*@Bean
	@Autowired 
	public HibernateTransactionManager txmanager(final SessionFactory sessionFactory)
	{
		final HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}
	*/
	public Properties hibernateProperties() 
	{
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", rb.getString("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", rb.getString("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", rb.getString("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.format_sql", rb.getString("hibernate.format_sql"));
		return hibernateProperties;
	}
	


}
