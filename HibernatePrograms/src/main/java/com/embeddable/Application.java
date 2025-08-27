package com.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Car;
import com.model.CarId;
import com.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		insert(session);
		
	//	select(session);
		
		
	}

	private static void select(Session session) {
		Car car = session.find(Car.class, new CarId(2,"nfksu56783"));
		System.out.println(car);
	}

	private static void insert(Session session) {
		session.beginTransaction();
		
		Car car = new Car(new CarId(2, "123hjndbr"),"Maruthi Suzuki",10000000);
		session.persist(car);
		
		session.getTransaction().commit();
	}

}
