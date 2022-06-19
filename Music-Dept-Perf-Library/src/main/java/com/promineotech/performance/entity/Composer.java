package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Composer {
	private int idcomposer;
	private String first_name;
	private String last_name;
}
