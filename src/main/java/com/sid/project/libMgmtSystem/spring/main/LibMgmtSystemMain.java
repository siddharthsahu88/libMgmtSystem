package com.sid.project.libMgmtSystem.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sid.project.libMgmtSystem.spring")
public class LibMgmtSystemMain {

	public static void main(String[] args) {
		SpringApplication.run(LibMgmtSystemMain.class, args);
	}

}