package cloud.aluno;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class DisciplinaServiceProxy {

	@Autowired
	DisciplinaClient disciplinaClient;

	@HystrixCommand(fallbackMethod = "getNomesDisciplinasFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "requestCache.enabled", value = "false"), }, 
			threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "5"),
					@HystrixProperty(name = "maximumSize", value = "5") })
	public List<String> getAllDisciplinas() {
		Resources<DisciplinaDTO> disciplinas = disciplinaClient.getAllDisciplinas();
		List<String> nomesDisciplinas = disciplinas.getContent().stream().map(d -> d.getNome())
				.collect(Collectors.toList());
		return nomesDisciplinas;
	}
	
	public List<String> getNomesDisciplinasFallback(Throwable e) {
		return Arrays.asList("PORT","MAT");
	}
	
}
