package com.promineotech.performance.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Songs {
	private int song_pk;
	private Composer composer;
	private String song_title;
	private SongType song_type;
}
