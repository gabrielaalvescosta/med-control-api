package com.medcontrol.medcontrol;

import com.medcontrol.medcontrol.config.WelcomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class MedcontrolApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedcontrolApplication.class, args);
	}

}
