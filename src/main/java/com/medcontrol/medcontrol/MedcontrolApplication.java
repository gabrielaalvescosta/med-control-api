package com.medcontrol.medcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.medcontrol.medcontrol")
public class MedcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedcontrolApplication.class, args);
	}

}
