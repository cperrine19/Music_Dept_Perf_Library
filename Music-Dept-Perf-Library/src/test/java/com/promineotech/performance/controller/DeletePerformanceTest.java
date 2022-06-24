package com.promineotech.performance.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
	void testThatPerformancesAreDeletedWhenAPerformanceIsSupplied() {
		// Given: a valid date and URI
		String body = deletePerformanceBody();
		String uri = String.format("http://localhost:%d/deletePerformances", serverPort);
		//need to delete using both date and performance name
		 HttpHeaders headers = new HttpHeaders(); //this is step 2g in the week16 homework
		 headers.setContentType(MediaType.APPLICATION_JSON); //on MediatType I imported springboot but it might need the swagger import 
		 
		 HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers); //step 2h
		
		// When: a connection is made to the URI
		ResponseEntity<List<Performances>> response = restTemplate.exchange(uri, HttpMethod.DELETE, bodyEntity, new ParameterizedTypeReference<>() {});

		// Then: a success (OK 200) is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK); //?
		assertThat(response.getBody()).isNull(); //?
		Performances performances = (Performances) response.getBody();
		assertThat(performances.getPerformance_name()).isNull(); 
		assertThat(performances.getPerformance_date()).isNull();


		// And: 




	};

	private String deletePerformanceBody() {
		///helppppppp
		return null;
	}
}
