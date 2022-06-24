package com.promineotech.performance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.DeletePerformance;
import com.promineotech.performance.entity.Performances;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/deletePerformance")

@OpenAPIDefinition(info = @Info(title = "Create a Performance"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })

public interface DeletePerformanceController {
	// @formatter:off
	@Operation(
		summary = "Delete a performance",
		description = "Deletes a performance",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "The performance is deleted",
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
						name = "Insert a Performance Date",
						allowEmptyValue = false,
						required = false,
						description = "The specified date (in this format: 2020-01-11)"),
				@Parameter(
						name = "Insert a Performance Name",
						allowEmptyValue = false,
						required = false,
						description = "The name of the performance (i.e. Johns Senior Recital)")
		}
	)

	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	List<Performances> deletePerformance (@Valid @RequestBody DeletePerformance deletePerf); // check this
 	// @formatter:on
	
	//deletePerformance is the same as createOrder in Jeeps
	//DeletePerformance is the same as OrderRequest in Jeeps
	//deletePerf is the same as request in Jeeps
	}