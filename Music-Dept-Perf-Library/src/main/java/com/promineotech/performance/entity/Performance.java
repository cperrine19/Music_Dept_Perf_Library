package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Performance {
	private int idperformances;
	private String date;
	private int idperformer;
	private int idsong_title;
	private int idsong_type;
	private int idcomposer;
}
