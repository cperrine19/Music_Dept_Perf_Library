package com.promineotech.performance.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class DeleteComposer {
	@NotNull
	@Length(max = 45)
	@Pattern(regexp = "[\\w\\s]*")
	private String first_name;
	
	@NotNull
	@Length(max = 45)
	@Pattern(regexp = "[\\w\\s]*")
	private String last_name;


	}


