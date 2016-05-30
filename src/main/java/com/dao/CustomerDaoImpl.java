package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.utils.SpringCoreHibernateUtils;


@Configuration
@Repository
public class CustomerDaoImpl {
	
	
	@Autowired
	private SessionFactory sf;
	
	public CustomerDaoImpl()
	{
		System.out.println("SF created"+sf);
	}
	
	public static void main(String[] args) 
	{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AnnotationConfigApplicationContext atx = new AnnotationConfigApplicationContext(SpringCoreHibernateUtils.class);
		SessionFactory sess = (SessionFactory)atx.getBean("sessionFactory");
		System.out.println(sess);
		new CustomerDaoImpl();
	}
}
