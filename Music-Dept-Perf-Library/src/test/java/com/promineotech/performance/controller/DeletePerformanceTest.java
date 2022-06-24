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


public class DeletePerformanceTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int serverPort;
	
	@Test
	void testDeletePerformanceReturnsSuccess202() { //should be 202 "accepted"?
		// Given: a valid date and URI
		String body = deletePerformanceBody();
		String uri = String.format("http://localhost:%d/deletePerformance", serverPort);
		//need to delete using both date and performance name
		 HttpHeaders headers = new HttpHeaders(); //this is step 2g in the week16 homework
		 headers.setContentType(MediaType.APPLICATION_JSON); //on MediatType I imported springboot but it might need the swagger import 
		 
		 HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers); //step 2h
		
		// When: a connection is made to the URI
		ResponseEntity<Performances> response = restTemplate.exchange(uri, HttpMethod.DELETE, bodyEntity, new ParameterizedTypeReference<>() {});

		// Then: a success (OK 200) is returned- 202??
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT); //202 accepted??
		assertThat(response.getBody()).isNull(); //?
//		Performances performances = (Performances) response.getBody();
//		assertThat(performances.getPerformance_name()).isNull(); 
//		assertThat(performances.getPerformance_date()).isNull();


		// And: 




	};

	private String deletePerformanceBody() {
		//heeelllpp
		// @formatter: off
		return "{\n"
			+ "  \"performance_name\":\"Johns Senior Recital\",\n"
			+ "  \"performance_date\":\"2020-02-02\"\n"
			+ "  \n"
			+ "}";
		// @formatter:on
	}
}
