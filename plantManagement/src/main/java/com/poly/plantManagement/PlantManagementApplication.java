package com.poly.plantManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PlantManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PlantManagementApplication.class, args);
	}
	
    @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder 
 application) {
    return application.sources(PlantManagementApplication.class);
 }

}
