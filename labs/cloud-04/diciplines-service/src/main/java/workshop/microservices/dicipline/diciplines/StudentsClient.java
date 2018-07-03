package workshop.microservices.dicipline.diciplines;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import workshop.microservices.dicipline.diciplines.model.StudentDTO;

@FeignClient("STUDENTS-SERVICE")
public interface StudentsClient {

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	List<StudentDTO> findAllStudents();

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	StudentDTO getStudent(@PathVariable("id") Long id);
}
