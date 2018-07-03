package com.example.workshop.microservices.students.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.workshop.microservices.students.model.Student;
import com.example.workshop.microservices.students.repository.StudentsRepository;

@Component
public class InitiData  implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitiData.class);


	@Autowired
	private StudentsRepository studentsRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOGGER.info("#############  InitiData  ###############");
		studentsRepository.saveAll(Arrays.asList(
				new Student(null, "Ramiro", 1, "Ramiro.pedrozo@gmail.com", LocalDate.now().plusMonths(1L)),
				new Student(null, "Romario", 2, "Romario.pedrozo@gmail.com", LocalDate.now().plusMonths(2L)),
				new Student(null, "Roberto Carlos", 3, "Roberto.pedrozo@gmail.com", LocalDate.now().plusMonths(2L)),
				new Student(null, "Rivalvdo", 3, "Rivalvdo.pedrozo@gmail.com", LocalDate.now().plusMonths(4L))));
		LOGGER.info("############################");
	}

}
