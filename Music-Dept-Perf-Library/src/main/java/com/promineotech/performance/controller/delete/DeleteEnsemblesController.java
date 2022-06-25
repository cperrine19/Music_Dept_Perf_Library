package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.DeleteEnsemble;
import com.promineotech.performance.entity.Ensembles;
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
@RequestMapping("/deleteEnsembles")

@OpenAPIDefinition(info = @Info(title = "Delete an Ensemble"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })

public interface DeleteEnsemblesController {
	// @formatter:off
		@Operation(
			summary = "Delete an ensemble",
			description = "Deletes an ensemble",
			responses = {
					@ApiResponse(
							responseCode = "202", //changed from 200
							description = "Accepted: The ensemble is deleted",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Performances.class))),
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
		List<Ensembles> deleteEnsemble (@Valid @RequestBody DeleteEnsemble deleteEns); // check this
	 	// @formatter:on

}
