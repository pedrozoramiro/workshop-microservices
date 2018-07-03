package com.example.workshop.microservices.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.workshop.microservices.students.config.RibbonConfiguration;
import com.example.workshop.microservices.students.dto.StudentDTO;

@RestController
@RequestMapping("/students-ribbon")
@RibbonClient(name = "diciplines-service", configuration = RibbonConfiguration.class)
public class StudentController {
	
	
	@Autowired RestTemplate restTemplate;
	
	
	@GetMapping
	public StudentDTO findAllStudentsByMonthBirthday() {
		StudentDTO stu = new StudentDTO();                       
		ResponseEntity<List> entity = restTemplate.getForEntity("http://diciplines-service/diciplines/names", List.class);
		stu.setDisciplinas(entity.getBody());
		return stu;
		
	}
}
