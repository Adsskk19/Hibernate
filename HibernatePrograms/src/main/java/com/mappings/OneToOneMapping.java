package com.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Passport;
import com.model.User;
import com.util.HibernateUtil;

public class OneToOneMapping {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
    //	insert(session);
//		select(session);
	//	delete(session);
		Passport passport = session.find(Passport.class, 1003);
		System.out.println(passport);
		System.out.println(passport.getUser());
	}
	
	

	private static void delete(Session session) {
		session.beginTransaction();
		session.remove(new User(3,"",new Passport(1001,"")));
		session.getTransaction().commit();
	}

	private static void select(Session session) {
		User user = session.find(User.class, 1);
		System.out.println(user);
	}

	private static void insert(Session session) {
		User user = new User("Sandhya");
		Passport passport = new Passport(1003,"Chennai");
		user.setPassport(passport);
		passport.setUser(user);
		
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}

}
