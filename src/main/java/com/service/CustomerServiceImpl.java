package com.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl 
{
	@Autowired
	private SessionFactory sf;
	public CustomerServiceImpl()
	{
		System.out.println("SF created"+sf);
	}
	public static void main(String[] args) 
	{
		new CustomerServiceImpl();
	}
}
