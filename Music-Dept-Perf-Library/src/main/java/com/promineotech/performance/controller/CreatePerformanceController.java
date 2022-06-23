package com.promineotech.performance.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.CreatePerformance;
import com.promineotech.performance.entity.Performances;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/createPerformances") //step 3 in week16 homework

//jeep project includes @OpenAPIDefinition(info = @Info(title = "Jeep Order Service"), servers = {
//@Server(url = "http://localhost:8080", description = "Local server.") })


public interface CreatePerformanceController {
	// @formatter:off
	@Operation(
		summary = "Create a performance",
		description = "Returns the created performance",
		responses = {
				@ApiResponse(
						responseCode = "201",
						description = "The created performance is returned",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Performances.class))),
				@ApiResponse(
						responseCode = "400",
						description = "The request parameters are invalid",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404",
						description = "No performances were found with the input criteria",
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500",
						description = "An unplanned error occurred",
						content = @Content(mediaType = "application/json")),
		},
		parameters = {
				@Parameter(
						name = "createPerformance", //double check this
						allowEmptyValue = false,
						required = true,
						description = "The created performances as JSON")
		}
	)
	// @formatter:on

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Performances createPerformance (@Valid @RequestBody CreatePerformance create); //check this
	//createPerformance is the same as createOrder in Jeeps
	//CreatePerformance is the same as OrderRequest in Jeeps
	//create is the same as request in Jeeps
}
