package workshop.microservices.dicipline.diciplines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import workshop.microservices.dicipline.diciplines.model.DisciplineDTO;

@RestController
@RequestMapping("diciplines")
public class DiciplinesController {
	
    private static final String STUDENTS_SERVICE = "students-service";

	private static final String GET_STUDENTS = "http://%s:%s/students";

	@Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping
	public ResponseEntity<DisciplineDTO> getDisciplina() {
		DisciplineDTO disciplinaDTO = new DisciplineDTO();
		ServiceInstance instance = this.discoveryClient.getInstances(STUDENTS_SERVICE).get(0);
        ResponseEntity<JsonNode> students = restTemplate.getForEntity(String.format(GET_STUDENTS , instance.getHost(),instance.getPort()), JsonNode.class);
        disciplinaDTO.setStudents(students.getBody().findValuesAsText("nome"));
        return ResponseEntity.ok(disciplinaDTO);
    }

 
}
