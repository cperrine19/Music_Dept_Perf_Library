package com.promineotech.performance.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePerformance {
	
	@NotNull
	private String performance_date;
	
	@NotNull
	@Length(max = 45)
	@Pattern(regexp = "[\\w\\s]*")
	private String performance_name;

}
