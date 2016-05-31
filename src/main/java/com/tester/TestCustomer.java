package com.tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringCoreHibernateUtils;
import com.pojos.Customer;
import com.service.CustomerServiceImpl;

public class TestCustomer 
{
	private static AnnotationConfigApplicationContext atx;

	public static void main(String[] args) 
	{
		//To load the Annotated Configuration Class
		atx = new AnnotationConfigApplicationContext(SpringCoreHibernateUtils.class);
		//This will scan the mentioned package and will look for annotation 
		atx.scan("com");
		//Service Class will be loaded
		CustomerServiceImpl service = atx.getBean(CustomerServiceImpl.class);
		//Creating a new object
		Customer c = new Customer();
		c.setName("John Snow");
		//Calling register function of service class
		service.registerCustomer(c);
	}
}
