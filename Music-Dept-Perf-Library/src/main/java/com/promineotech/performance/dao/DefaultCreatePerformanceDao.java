package com.promineotech.performance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.performance.Performance;
import com.promineotech.performance.entity.Performances;

@Component
public class DefaultCreatePerformanceDao implements CreatePerformanceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public Performances savePerformance(String performance_date, String performance_name) {
		SqlParams params = 
				generateInsertSql(performance_date, performance_name);
		
		
		// @formatter:off
				return Performances.builder()
						.performance_date(performance_date)
						.performance_name(performance_name)
						.build();
		// @formatter:on;
	}
	private SqlParams generateInsertSql(String performance_date, String performance_name) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO performances ("
				+ "performance_name, performance_date"
				+") VALUES ("
				+ ":performance_name, :performance_date"
				+ ")";
		// @formatter:on
		
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("performance_name", performance_name); //stuck here
		params.source.addValue("performance_date", performance_date); //stuck here
		
		return params;

	}
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	}


