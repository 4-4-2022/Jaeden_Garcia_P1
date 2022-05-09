package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@SpringBootApplication
public class EnrollServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollServiceApplication.class, args);
	}
	@Bean 
	public RestTemplate restTemplate1(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public RestTemplate restTemplate2() {
		final String BASE_URL = "http://localhost:8081/soap-service"; //service port being connected to, not self port
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(BASE_URL);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		return restTemplate;
	}
}
