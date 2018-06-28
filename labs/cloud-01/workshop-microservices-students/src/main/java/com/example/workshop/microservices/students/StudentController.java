package com.example.workshop.microservices.students;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RefreshScope
public class StudentController {

	@Value("${student.name}")
	private String name;

	@GetMapping
	public String findOne() {
		return name;
	}
}
