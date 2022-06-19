package com.promineotech.performance.entity;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Performances {
	private int idperformances;
	private Date date;
	private int idperformer;
	private int idsong_title;
	private int idsong_type;
	private int idcomposer;
}
