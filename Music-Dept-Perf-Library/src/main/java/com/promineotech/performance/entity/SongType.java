package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongType {
	private int idsong_type;
	private String performance_type;
}
