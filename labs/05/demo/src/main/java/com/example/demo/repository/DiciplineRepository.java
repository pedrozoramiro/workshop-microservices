package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.model.Discipline;

@RepositoryRestResource() 
public interface DiciplineRepository extends JpaRepository<Discipline, Long> {

	@RestResource(path = "findbystartdate")
	@Query("from Discipline dicipline where dicipline.startDate > CURRENT_DATE")
	List<Discipline> findByStartDateAfterCurrent();
}