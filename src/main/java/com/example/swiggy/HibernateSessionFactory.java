//package com.example.swiggy;
//
//import org.hibernate.cfg.Configuration;
//import org.hibernate.SessionFactory;
//
//public class HibernateSessionFactory {
//
//	public static SessionFactory factory;
//
//	private HibernateSessionFactory() {
//	}
//
//	public static synchronized SessionFactory getSessionFactory() {
//		if (factory == null) {
//			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		}
//		return factory;
//	}
//}