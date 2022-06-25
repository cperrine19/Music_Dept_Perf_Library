package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Composer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/composers")
public interface ComposersController {
	// @formatter:off
		@Operation(
			summary = "Returns a list of composers",
			description = "Returns a list of composers given specific parameters",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of composers is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Composer.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No composers were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")),
			},
			parameters = {
					@Parameter(
							name = "first_name",
							allowEmptyValue = false,
							required = false,
							description = "A composer first name"),
					@Parameter(
							name = "last_name",
							allowEmptyValue = false,
							required = false,
							description = "A composer last name")
			}
		)

		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Composer> fetchComposers(
				@RequestParam(required = false) 
					String first_name,
				@RequestParam(required = false)
					String last_name);
		
		// @formatter:on
}
