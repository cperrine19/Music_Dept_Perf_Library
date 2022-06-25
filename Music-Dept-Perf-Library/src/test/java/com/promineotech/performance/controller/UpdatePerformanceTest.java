package com.promineotech.performance.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.performance.entity.Performances;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:Music_Dept_Perf_Library_Schema.sql",
		"classpath:Music_Dept_Perf_Library_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))


public class UpdatePerformanceTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int serverPort;
	
	@Test
	void testUpdatePerformanceReturnsSuccess200() { //should be 202 "accepted"?
		// Given: a valid date and URI
		String body = updatePerformanceBody();
		String uri = String.format("http://localhost:%d/updatePerformance", serverPort);
		//need to delete using both date and performance name
		 HttpHeaders headers = new HttpHeaders(); //this is step 2g in the week16 homework
		 headers.setContentType(MediaType.APPLICATION_JSON); //on MediatType I imported springboot but it might need the swagger import 
		 
		 HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers); //step 2h
		
		// When: a connection is made to the URI
		ResponseEntity<Performances> response = restTemplate.exchange(uri, HttpMethod.PUT, bodyEntity, new ParameterizedTypeReference<>() {});

		// Then: a success (OK 200) is returned- 202??
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); //202 accepted??
		assertThat(response.getBody()).isNotNull();
		Performances performances = response.getBody();
		assertThat(performances.getPerformance_name()).isEqualTo("Johns Junior Recital");
		assertThat(performances.getPerformance_date()).isEqualTo("2020-02-02");


		// And: 




	};

	private String updatePerformanceBody() {
		// @formatter: off
		return "{\n"
			+ "  \"Old\": {"
			+ "    \"performance_name\":\"Johns Senior Recital\",\n"
			+ "    \"performance_date\":\"2020-02-02\"\n"
			+ "  },"
			+ "  \"New\": {"
			+ "    \"performance_name\":\"Johns Junior Recital\",\n"
			+ "    \"performance_date\":\"2020-02-02\"\n"
			+ "  }\n"
			+ "}";
		// @formatter:on
	}
}
