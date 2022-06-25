package com.promineotech.performance.controller.create;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.CreateComposer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/createComposer")
public interface CreateComposerController {
	// @formatter:off
		@Operation(
			summary = "Add a composer",
			description = "Returns the added Comnposer",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "The added Composer is returned",
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
							name = "Add a Composer First Name",
							allowEmptyValue = false,
							required = false,
							description = "Add the composer's first name"),
					@Parameter(
							name = "Ad ad Composer Last Name",
							allowEmptyValue = false,
							required = false,
							description = "Add the composer's last name")
			}
		)

		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Composer createComposer (@Valid @RequestBody CreateComposer createComposer); //check this
		// @formatter:on

}
