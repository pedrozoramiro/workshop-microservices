package com.example.workshop.microservices.students.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.workshop.microservices.students.model.Student;

@RepositoryRestResource() 
public interface StudentsRepository extends JpaRepository<Student, Long> {

	
	List<Student> findAllByNome(String name);

	@Query("select student from Student student where MONTH(student.dataNascimento) = :month")
	List<Student> findAllStudentsByMonthBirthday(@Param("month") Integer month);
}
