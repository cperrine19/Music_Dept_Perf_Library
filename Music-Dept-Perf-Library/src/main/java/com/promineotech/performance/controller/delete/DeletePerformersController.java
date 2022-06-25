package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.DeletePerformer;
import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.entity.Performers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/deletePerformer")

@OpenAPIDefinition(info = @Info(title = "Delete a Performer"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })
public interface DeletePerformersController {
	// @formatter:off
		@Operation(
			summary = "Delete a performer",
			description = "Deletes a performer",
			responses = {
					@ApiResponse(
							responseCode = "202", //changed from 200
							description = "Accepted: The performer is deleted",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Performances.class))),
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
							name = "Insert a Performer First Name",
							allowEmptyValue = false,
							required = false,
							description = "The performers first name"),
					@Parameter(
							name = "Insert a Performer Last Name",
							allowEmptyValue = false,
							required = false,
							description = "The performers last name")
			}
		)

		
		@DeleteMapping
		@ResponseStatus(HttpStatus.NO_CONTENT)
		List<Performers> deletePerformers (@Valid @RequestBody DeletePerformer deletePerformer); // check this
	 	// @formatter:on
}
