package com.promineotech.performance.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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

class CreatePerformanceTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;

	@Test
	void testCreatePerformanceReturnsSuccess201() {
		// Given: a performance as JSON
		 String body = createPerformanceBody();
		 String uri = String.format("http://localhost:%d/createPerformances", serverPort);
		 	//this uri is based on the jeep orders test- step 2f in Week16
		 
		 HttpHeaders headers = new HttpHeaders(); //this is step 2g in the week16 homework
		 headers.setContentType(MediaType.APPLICATION_JSON); //on MediatType I imported springboot but it might need the swagger import 
		 
		 HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers); //step 2h


		// When: the performance is entered
			ResponseEntity<Performances> response = restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, Performances.class);
				//step 2i
			
		// Then: a 201 status is returned
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
			assertThat(response.getBody()).isNotNull();
			Performances performances = response.getBody();
			assertThat(performances.getPerformance_name()).isEqualTo("Johns Senior Recital"); //not sure this is correct format
			assertThat(performances.getPerformance_date()).isEqualTo("2020-02-02");
			
			//step2j

		// and: the returned performance is correct
		};

	protected String createPerformanceBody() {
		// @formatter: off
		return "{\n"
			+ "  \"performance_name\":\"Johns Senior Recital\",\n"
			+ "  \"performance_date\":\"2020-02-02\",\n"
			+ "  ]\n"
			+ "}";
		// @formatter:on
		
	}

}
