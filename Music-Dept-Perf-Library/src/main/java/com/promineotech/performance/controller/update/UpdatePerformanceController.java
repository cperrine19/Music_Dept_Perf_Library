package com.promineotech.performance.controller.update;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.entity.UpdatePerformance;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Data;

@Validated
@RequestMapping("/updatePerformance")

@OpenAPIDefinition(info = @Info(title = "Update a Performance"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })

public interface UpdatePerformanceController {
	// @formatter:off
	@Operation(
		summary = "Update a performance",
		description = "Updates a performance",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "The performance is updated",
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
						name = "Performance Date (old)",
						allowEmptyValue = false,
						required = false,
						description = "The specified date for the previously entered Performance (in this format: 2020-01-11)"),
				@Parameter(
						name = "Performance Name (old)",
						allowEmptyValue = false,
						required = false,
						description = "The name for the previously entered Performance (i.e. Johns Senior Recital)"),
				@Parameter(
						name = "Performance Date (new)",
						allowEmptyValue = false,
						required = false,
						description = "The specified date for the updated Performance (in this format: 2020-01-11)"),
				@Parameter(
						name = "Performance Name (new)",
						allowEmptyValue = false,
						required = false,
						description = "The name for the updated Performance (i.e. Johns Senior Recital)")
		}
	)

	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	List<Performances> updatePerformance (
			@Valid @RequestBody Map<String, UpdatePerformance> performances);
 	// @formatter:on
	
	//deletePerformance is the same as createOrder in Jeeps
	//DeletePerformance is the same as OrderRequest in Jeeps
	//deletePerf is the same as request in Jeeps
	}
