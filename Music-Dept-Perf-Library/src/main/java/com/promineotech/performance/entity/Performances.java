package com.promineotech.performance.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.performance.Performance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Performances {
	private int performance_pk;
	private String performance_name; 
	private String performance_date;
	private List<Songs> songs;
	private List<Ensembles> ensembles;
	
	@JsonIgnore
	public int getPerformance_pk() {
		return performance_pk;
	}
}
