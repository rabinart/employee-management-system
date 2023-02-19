package com.rabinart.ems;

import com.rabinart.ems.database.entity.Busyness;
import com.rabinart.ems.database.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EmsApplication.class, args);

		EntityManagerFactory factory = applicationContext.getBean("entityManagerFactory", EntityManagerFactory.class);

		var entityManager = factory.createEntityManager();
		var employee = entityManager.find(Employee.class, 1);
		var busyness = employee.getBusyness();
		System.out.println(busyness.toString());

	}

}
