package com.promineotech.performance.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateEnsembles {
	@NotNull
	private String ensemble_name;
	
	@NotNull
	private int member_size;

}
