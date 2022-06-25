package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.DeleteComposer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/deleteComposer")

@OpenAPIDefinition(info = @Info(title = "Delete a Composer"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })

public interface DeleteComposerController {
	// @formatter:off
		@Operation(
			summary = "Delete a composer",
			description = "Deletes a composer",
			responses = {
					@ApiResponse(
							responseCode = "202", //changed from 200
							description = "Accepted: The composer has been deleted",
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
							name = "Insert a Composer First Name",
							allowEmptyValue = false,
							required = false,
							description = "Composer First Name"),
					@Parameter(
							name = "Insert a Composer Last Name",
							allowEmptyValue = false,
							required = false,
							description = "Composer Last Name")
			}
		)

		
		@DeleteMapping
		@ResponseStatus(HttpStatus.NO_CONTENT)
		List<Composer> deleteComposer (@Valid @RequestBody DeleteComposer deleteComp); // check this
	 	// @formatter:on

}
