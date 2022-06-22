package com.promineotech.performance.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Performers {
	private int performer_pk;
	private String first_name;
	private String last_name;
	private InstrumentVoiceType instrumentVoiceType;
	private List<Ensembles> ensembles;
}
