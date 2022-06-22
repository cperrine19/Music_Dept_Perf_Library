package com.promineotech.performance.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ensembles {
	private int ensemble_pk;
	private String ensemble_name;
	private int member_size;
	private List<Performances> performances;
	private List<Performers> performers;
}
