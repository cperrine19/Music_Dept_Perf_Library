package com.promineotech.performance.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data

public class CreatePerformance {
   //did not include bean validation- step 7 in week 16
	private String performance_name;
	private String performance_date;
	private List<String> performances; //not sure about what to use here
}
