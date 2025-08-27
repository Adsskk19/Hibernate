package com.mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Course;
import com.model.Trainee;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;
import com.util.HibernateUtil;

public class ManyToManyMapping {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
//		insert(session);
		
		Trainee trainee = session.find(Trainee.class, 3);
		System.out.println(trainee);
		System.out.println(trainee.getCourses());
		
		
		
	}

	private static void insert(Session session) {
		session.beginTransaction();
		
		List<Trainee> trainees1 = new ArrayList<Trainee>();
		List<Trainee> trainees2 = new ArrayList<Trainee>();
		List<Course> courses1 = new ArrayList<Course>();
		List<Course> courses2 = new ArrayList<Course>();

		Trainee t1 = new Trainee("Deepak");
		Trainee t2 = new Trainee("Jagadeesh");
		Trainee t3 = new Trainee("Prashanth");

		trainees1.add(t1);
		trainees1.add(t2);
		trainees2.add(t3);

		Course c1 = new Course("JFS");
		Course c2 = new Course("Adv Java");		
		Course c3 = new Course("AI");		

		courses1.add(c1);
		courses1.add(c2);
		courses2.add(c3);
		
		t1.setCourses(courses1);
		t2.setCourses(courses1);
		t3.setCourses(courses2);
		
		c1.setTrainees(trainees1);
		c2.setTrainees(trainees1);
		c3.setTrainees(trainees2);
		
		session.persist(t1);
		session.persist(t2);
		session.persist(t3);
		
		session.getTransaction().commit();
	}

}
