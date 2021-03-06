package com.promineotech.performance.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
class FetchPerformanceTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;

	@Test
	void testThatPerformancesAreReturnedWhenADateIsSupplied() {
		// Given: a valid date and URI
		String date = "2017-06-15";
		String uri = String.format("http://localhost:%d/performances?date=%s", serverPort, date);
		
		// When: a connection is made to the URI
		ResponseEntity<List<Performances>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a success (OK 200) is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// And: the actual list returned is the same as the expected list
		List<Performances> expected = buildExpectedPerformanceDate();
		assertThat(response.getBody()).isEqualTo(expected);
	}

	@Test
	void testThatPerformancesAreReturnedWhenAPerformanceNameIsSupplied() {
		// Given: a valid date and URI
		String name = "Jordans Senior Recital";
		String uri = String.format("http://localhost:%d/performances?name=%s", serverPort, name);
		
		// When: a connection is made to the URI
		ResponseEntity<List<Performances>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a success (OK 200) is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// And: the actual list returned is the same as the expected list
		List<Performances> expected = buildExpectedPerformanceName();
		assertThat(response.getBody()).isEqualTo(expected);
	}
	
	@Test
	void testThatPerformancesAreReturnedWhenAPerformanceNameAndDateIsSupplied() {
		// Given: a valid date and URI
		String name = "Chelseas Senior Recital";
		String date = "2011-05-05";
		String uri = String.format("http://localhost:%d/performances?name=%s&date=%s", serverPort, name, date);
		
		// When: a connection is made to the URI
		ResponseEntity<List<Performances>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a success (OK 200) is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// And: the actual list returned is the same as the expected list
		List<Performances> expected = buildExpectedPerformanceNameAndDate();
		assertThat(response.getBody()).isEqualTo(expected);
	}
	
	protected List<Performances> buildExpectedPerformanceDate() {
		List<Performances> list = new LinkedList<>();
		
		// @formatter:off
		list.add(Performances.builder()
			.performance_name(null)
			.performance_date("2017-06-15")
			.build());
		
		list.add(Performances.builder()
			.performance_name(null)
			.performance_date("2017-06-15")
			.build());
		// @formatter:on
		
		return list;
	}
	
	protected List<Performances> buildExpectedPerformanceName() {
		List<Performances> list = new LinkedList<>();
		
		// @formatter:off
		list.add(Performances.builder()
			.performance_name("Jordans Senior Recital")
			.performance_date("2019-05-05")
			.build());
		
		list.add(Performances.builder()
			.performance_name("Jordans Senior Recital")
			.performance_date("2019-05-05")
			.build());
		// @formatter:on
		
		return list;
	}
	
	protected List<Performances> buildExpectedPerformanceNameAndDate() {
		List<Performances> list = new LinkedList<>();
		
		// @formatter:off
		list.add(Performances.builder()
			.performance_name("Chelseas Senior Recital")
			.performance_date("2011-05-05")
			.build());
		// @formatter:on
		
		return list;
	}

}
