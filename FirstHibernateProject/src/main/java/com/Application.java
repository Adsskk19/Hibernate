package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.util.HibernateUtil;

public class Application {
	public static void main(String[] args) {
		
		//getData();
		//updateData();
		//deleteData();
		//System.out.println("Deleted");
		insertData();
		
		
	}
	private static void insertData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//Provides a session
		
		Session session = sessionFactory.openSession(); 
		//session which is interacting with database.
		
		Employee emp = new Employee("jkass@gmail.com",34000);
		
		session.beginTransaction();
		
		session.persist(emp);
		
		session.getTransaction().commit();
		
		System.out.println("Inserted...");
	}
	public static void getData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Employee employee = session.find(Employee.class,2);		
		//load & get deprecated now  find method
		 
		System.out.println(employee);
	}
	public static void updateData() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Employee emp = session.find(Employee.class, 1);
		//emp.setEmpId(1);
		emp.setSalary(35000);
		
		session.beginTransaction();
		//session.merge(emp);
		session.getTransaction().commit();
		
		session.close();
	}
	public static void deleteData() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Employee emp = new Employee(12,"",0);
		session.beginTransaction();
		
		session.remove(emp);
		
		session.getTransaction().commit();
		
		
	}
	
	
	
	
	
	

}
