package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongTitle {
	private int idsong_title;
	private String title;
	private int idcomposer;
	
}
