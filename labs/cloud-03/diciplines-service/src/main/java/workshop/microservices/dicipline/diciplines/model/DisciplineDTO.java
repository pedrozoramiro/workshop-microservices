package workshop.microservices.dicipline.diciplines.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
	private Long id;
	private String name;
	private Integer workload;
	private LocalDate startDate;
    List<String> students;
}
