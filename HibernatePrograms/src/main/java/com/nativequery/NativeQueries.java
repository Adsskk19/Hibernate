package com.nativequery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import com.model.Student;
import com.util.HibernateUtil;

public class NativeQueries {
	//Queries in SQL
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		insert(session);
//		select(session);	
	}
	//Write Queries for delete and Update
	private static void delete(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("Delete students(name,marks) set values(?1,?2)");
		query.setParameter(1, "Kishore");
		query.setParameter(2, 92);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	private static void update(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("Update students(name,marks) set values(?1,?2)");
		query.setParameter(1, "Kishore");
		query.setParameter(2, 92);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void insert(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("insert into students(name,marks) values(?1,?2)");
		query.setParameter(1, "Kishore");
		query.setParameter(2, 92);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	private static void select(Session session) {
		NativeQuery<Student> query = session.createNativeQuery("Select * from Student",Student.class);
		List<Student> list = query.list();
		System.out.println(list);
	}

}
