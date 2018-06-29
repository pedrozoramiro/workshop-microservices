package workshop.microservices.dicipline.diciplines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DiciplinesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiciplinesServiceApplication.class, args);
	}

}
