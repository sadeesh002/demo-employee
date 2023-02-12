package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee REST API",description="Performing CRUD operation",version="v1",license=@License(name="sadeesh's no1 license"),contact=@Contact(name="Sadeesh",email="sks002@gmail.com")))
public class DemoEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEmployeeApplication.class, args);
	}

}
