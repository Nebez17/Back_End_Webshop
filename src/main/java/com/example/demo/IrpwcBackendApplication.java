package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class IrpwcBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(IrpwcBackendApplication.class, args);
	}

}
