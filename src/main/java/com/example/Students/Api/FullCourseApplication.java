package com.example.Students.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FullCourseApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(FullCourseApplication.class, args);
	}
}
