package com.promineotech.performance.entity;

import lombok.Data;

@Data

public class CreatePerformance {
   //did not include bean validation- step 7 in week 16
	private String performance_name;
	private String performance_date;
}
