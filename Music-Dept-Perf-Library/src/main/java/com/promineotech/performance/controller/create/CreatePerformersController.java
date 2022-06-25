package com.promineotech.performance.controller.create;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.CreatePerformer;
import com.promineotech.performance.entity.Performers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/createPerformers")

public interface CreatePerformersController {
	// @formatter:off
		@Operation(
			summary = "Add a performer",
			description = "Returns the added performer",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "The added performer is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Performers.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No performers were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")),
			},
			parameters = {
					@Parameter(
							name = "Add a Performer's First Name",
							allowEmptyValue = false,
							required = false,
							description = "The performer's first name"),
					@Parameter(
							name = "Add a Performer's Last Name",
							allowEmptyValue = false,
							required = false,
							description = "The performer's last name")
			}
		)

		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Performers createPerformer (@Valid @RequestBody CreatePerformer createPerformer); //check this
		// @formatter:on
}
