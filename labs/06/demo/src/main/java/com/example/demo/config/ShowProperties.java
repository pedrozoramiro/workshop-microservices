package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ShowProperties  implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShowProperties.class);

	
	@Value("${client.name}")
	private String clientName;
	
	@Autowired
	private  Environment environment;
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOGGER.info("############################");
		LOGGER.info(clientName);
		LOGGER.info(environment.getProperty("client.name"));
		LOGGER.info("############################");
	}

}
