package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.util.HibernateUtil;

public class States {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Employee emp = new Employee(10,"dfg@gmail.com",23000); //Transient
		Employee emp2 = new Employee(13,"dfd@gmail.com",23456); 
		emp2.setSalary(10000);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.persist(emp); //persistent
		emp.setSalary(33000);
		session.getTransaction().commit();
		
		session.close();
		
		emp.setSalary(24000); //Detached
		
		
	}
}
