package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Assessment2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(Assessment2Application.class, args);
		StorageService storage=context.getBean(StorageService.class);
		storage.storeFile("file.txt");
		
		StorageService local1=context.getBean("localStorage",StorageService.class);
		StorageService local2=context.getBean("localStorage",StorageService.class);
		System.out.println("local1: "+local1);
		System.out.println("local2: "+local2);
        context.close();
	}

}
