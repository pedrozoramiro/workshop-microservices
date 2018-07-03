package workshop.microservices.dicipline.diciplines;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import workshop.microservices.dicipline.diciplines.model.DisciplineDTO;

@RestController
@RequestMapping("diciplines")
public class DiciplinesController {
	

	@Autowired
	StudentsClient studentsClient;

    @GetMapping
	public ResponseEntity<DisciplineDTO> findAllDiciplines() {
		DisciplineDTO disciplinaDTO = new DisciplineDTO();
        disciplinaDTO.setStudents(studentsClient.findAllStudents().stream().map(t->t.getNome()).collect(Collectors.toList()));
        return ResponseEntity.ok(disciplinaDTO);
    }
    
    @GetMapping("/names")
	public ResponseEntity<List<String>> findAllNamesDiciplines() {
		return ResponseEntity.ok( Arrays.asList("MAT","PORT","CIE","GEO"));
    }
    

 
}
