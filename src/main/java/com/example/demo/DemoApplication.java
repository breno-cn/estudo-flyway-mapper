package com.example.demo;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ResourceBundle;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		String user = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");

		Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/hello", user, password)
				.load();

		flyway.migrate();

		SpringApplication.run(DemoApplication.class, args);
	}

}
