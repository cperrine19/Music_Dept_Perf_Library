package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Performer {
	private int idperformer;
	private String artist_name;
}
