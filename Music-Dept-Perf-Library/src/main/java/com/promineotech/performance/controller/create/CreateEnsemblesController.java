package com.promineotech.performance.controller.create;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.CreateEnsembles;
import com.promineotech.performance.entity.Ensembles;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/createEnsembles")
public interface CreateEnsemblesController {
	// @formatter:off
		@Operation(
			summary = "Create an ensemble",
			description = "Returns the created ensemble",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "The created ensemble is returned",
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
							name = "Create an Ensemble Name",
							allowEmptyValue = false,
							required = false,
							description = "The specified name (such as Duet1)"),
					@Parameter(
							name = "Insert the Ensemble Members Size",
							allowEmptyValue = false,
							required = false,
							description = "The number of members in the ensemble: (such as [2] members)")
			}
		)

		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Ensembles createEnsembles (@Valid @RequestBody CreateEnsembles createEns); //check this
		// @formatter:on
}
