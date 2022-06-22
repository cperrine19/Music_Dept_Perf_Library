package com.promineotech.performance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Performance;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/performances")
public interface PerformanceController {
	// @formatter:off
	@Operation(
		summary = "Returns a list of performances",
		description = "Returns a list of performances given a specific date",
		responses = {
				@ApiResponse(
						responseCode = "200",
						description = "A list of performances is returned",
						content = @Content(
								mediaType = "application/json",
								schema = @Schema(implementation = Performance.class))),
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
						name = "date",
						allowEmptyValue = false,
						required = true,
						description = "The specified date (i.e. '2020-01-11')")
		}
	)
	// @formatter:on

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Performance> fetchPerformances(@RequestParam String date);
}
