package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtil;

public class Application {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Student student = new Student("Kumar",95);
		Student student2 = new Student("Mohan",95);
		Student student3 = new Student("Bhavishya",100);
		session.beginTransaction();
		session.persist(student); 
		session.persist(student2); 
		session.persist(student3); 
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
