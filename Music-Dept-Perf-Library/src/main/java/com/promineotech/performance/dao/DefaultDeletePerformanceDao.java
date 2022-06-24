package com.promineotech.performance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.entity.Performances;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDeletePerformanceDao implements DeletePerformanceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public List<Performances> saveDeletePerf(String performance_date, String performance_name) {
		SqlParams params = generateInsertSql(performance_date, performance_name);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		String sql2 = checkSql();
		Map<String, Object> params2 = getParams(performance_date, performance_name);
		// @formatter:off
			List<Performances> mockReturn = jdbcTemplate.query(sql2, params2, new RowMapper<>() {
				@Override
				public Performances mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
					
					return Performances.builder()
					.performance_pk(rs.getInt("performance_pk"))
					.performance_name(rs.getString("performance_name"))
					.performance_date(rs.getString("performance_date"))
					.build();
			 	// @formatter:on;
			}
		});
			log.debug("mockReturn line: {}", mockReturn);
		return mockReturn;
	}

	private SqlParams generateInsertSql(String performance_date, String performance_name) {
		// @formatter:off
		//not sure about this sql script format
		String sql = ""
				+ "DELETE FROM performances "
				+ "WHERE performance_date = :performance_date "
				+ "AND performance_name = :performance_name;";
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

	private String checkSql() {
		// @formatter:off
		String sql = ""
				+ "SELECT * FROM performances "
				+ "WHERE performance_date = :performance_date "
				+ "AND performance_name = :performance_name;";
		// @formatter:on
		return sql;
	}

	private Map<String, Object> getParams(String performance_date, String performance_name) {
		Map<String, Object> params = new HashMap<>();
		params.put("performance_date", performance_date);
		params.put("performance_name", performance_name);
		return params;

	}
}
