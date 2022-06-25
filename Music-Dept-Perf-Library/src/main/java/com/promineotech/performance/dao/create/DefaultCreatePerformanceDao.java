package com.promineotech.performance.dao.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.entity.Performances;

@Component
public class DefaultCreatePerformanceDao implements CreatePerformanceDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public Performances savePerformance(String performance_date, String performance_name) {
		SqlParams params =
		generateInsertSql(performance_date, performance_name);
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); //step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		
		
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
				+ "performance_date, :performance_name"
				+") VALUES ("
				+ ":performance_date, :performance_name"
				+ ")";
		// @formatter:on
		
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("performance_date", performance_date); 
		params.source.addValue("performance_name", performance_name); 
		
		return params;

	}
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
	
	}


