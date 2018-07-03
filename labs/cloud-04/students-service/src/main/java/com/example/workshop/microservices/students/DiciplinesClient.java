package com.example.workshop.microservices.students;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("diciplines-service")
public interface DiciplinesClient {


	      @RequestMapping(value = "/diciplines/names", method = RequestMethod.GET)
	      List<String> findAllDiciplines();
}
