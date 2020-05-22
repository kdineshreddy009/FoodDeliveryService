package com.example;
/*
https://javabeat.net/enableautoconfiguration-spring-boot/
placed this class under default package so that 
it @enableAutoconfiguration(from @SpringBootApplication) scans & enables 
all the classes from this path 
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/*
SpringBootApplication has @EnableAutoconfiguration, 
@ComponentScan - scans current & sub packages by default, you can exclude any by passing parameters
https://www.baeldung.com/spring-component-scanning  
@Configuration- As MainApplication itself is a bean 
*/

@SpringBootApplication
@EnableJpaRepositories("com.example.swiggy.dao") // to scan the interfaces
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
