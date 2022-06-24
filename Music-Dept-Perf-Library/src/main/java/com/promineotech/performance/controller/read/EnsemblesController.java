package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Ensembles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/ensembles")
public interface EnsemblesController {
	// @formatter:off
		@Operation(
			summary = "Returns a list of ensembles",
			description = "Returns a list of ensembles given specific parameters",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of ensembles is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Ensembles.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No ensembles were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")),
			},
			parameters = {
					@Parameter(
							name = "ensemble_name",
							allowEmptyValue = false,
							required = false,
							description = "The name of the ensemble (i.e. Duet1)"),
					@Parameter(
							name = "member_size",
							allowEmptyValue = false,
							required = false,
							description = "The size of the ensemble (i.e. 2)")
			})
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Ensembles> fetchEnsembles(
				@RequestParam(required = false) 
					String ensemble_name,
				@RequestParam(required = false)
					int member_size);
		
		// @formatter:on
}
