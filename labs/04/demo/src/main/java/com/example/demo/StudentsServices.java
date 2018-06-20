package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentsServices {

	@Autowired
	private StudentsRepository studentsRepository;

	public void init() {
		studentsRepository.saveAll(Arrays.asList(
				new Student(null, "Ramiro", 1, "Ramiro.pedrozo@gmail.com", LocalDate.now().plusMonths(1L)),
				new Student(null, "Romario", 2, "Romario.pedrozo@gmail.com", LocalDate.now().plusMonths(2L)),
				new Student(null, "Roberto Carlos", 3, "Roberto.pedrozo@gmail.com", LocalDate.now().plusMonths(2L)),
				new Student(null, "Rivalvdo", 3, "Rivalvdo.pedrozo@gmail.com", LocalDate.now().plusMonths(4L))));
	}

	public List<Student> findAllByName(String name) {
		return studentsRepository.findAllByNome(name);
	}

	public List<Student> findAll() {
		return studentsRepository.findAll();
	}

	public Student update(Student student) {
		return studentsRepository.save(student);
	}

	public void delete(Long id) {
		studentsRepository.deleteById(id);

	}

	public Student create(Student student) {
		return studentsRepository.save(student);
	}

	public Student findOne(Long id) {
		return studentsRepository.findById(id).get();
	}

	public Collection<Student> findAllStudentsByMonthBirthday(Integer month) {
		return studentsRepository.findAllStudentsByMonthBirthday(month);
	}

}
