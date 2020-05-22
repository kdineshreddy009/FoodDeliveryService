package com.example;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;

//Getting the EntityManagerFactory from a singleton in the PersistenceManager class
public class EmfProvider {

	private static final String db_pu = "EntityManagerFactoryPersistance";

	public static final boolean debug = true;

	private static final EmfProvider singleton = new EmfProvider();

	private EntityManagerFactory emf;

	private EmfProvider() {
	}

	public static EmfProvider getInstance() {
		return singleton;
	}

	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(db_pu);
		}
		if (debug) {
			System.out.println("factory created on: " + new Date());
		}
		return emf;
	}

	public void closeEmf() {
		if (emf.isOpen() || emf != null) {
			emf.close();
		}
		emf = null;
		if (debug) {
			System.out.println("EMF closed at: " + new Date());
		}
	}
}
//
//
//2020-05-20 12:10:29.744  WARN 53563 --- [           main] ConfigServletWebServerApplicationContext : 
//	Exception encountered during context initialization - 
//cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: 
//Error creating bean with name 'restaurantController': Unsatisfied dependency expressed through field 'restaurantService';
//
//nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 
//'restaurantServiceImpl': Unsatisfied dependency expressed through field 'restaurantdao'; 
//
//nested exception is org.springframework.beans.factory.BeanCreationException: 
//	Error creating bean with name 'restaurantRepository': 
//
//		Cannot create inner bean '(inner bean)#4d354a3e' of type [org.springframework.orm.jpa.SharedEntityManagerCreator] 
//while setting bean property 'entityManager'; 
//
//nested exception is org.springframework.beans.factory.BeanCreationException: 
//	Error creating bean with name '(inner bean)#4d354a3e':
//Cannot resolve reference to bean 'entityManagerFactory' while setting constructor argument; 
//nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 
//'entityManagerFactory' available



