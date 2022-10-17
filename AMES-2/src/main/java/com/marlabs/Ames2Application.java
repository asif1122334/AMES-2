package com.marlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.marlabs")
public class Ames2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ames2Application.class, args);
	}

}
