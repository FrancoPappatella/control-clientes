package com.pappatella.springboot.datajpa.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pappatella.springboot.datajpa.app.models.service.IUploadFileService;

@SpringBootApplication
public class ControlClientesApplication{

	public static void main(String[] args) {
		SpringApplication.run(ControlClientesApplication.class, args);
	}



}
