package com.promineotech.performance.dao.update;

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
public class DefaultUpdatePerformanceDao implements UpdatePerformanceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public List<Performances> updatePerformance(String old_performance_name, String old_performance_date,
			String new_performance_name, String new_performance_date) {

		SqlParams params = generateInsertSql(old_performance_name, old_performance_date, new_performance_name,
				new_performance_date);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		String sql = checkSql();
		Map<String, Object> params2 = getParams(new_performance_name, new_performance_date);
		
		// @formatter:off
		List<Performances> mockReturn = jdbcTemplate.query(sql, params2, new RowMapper<>() {
			
			@Override
			public Performances mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Performances.builder()
						.performance_pk(rs.getInt("performance_pk"))
						.performance_name(rs.getString("performance_name"))
						.performance_date(rs.getString("performance_date"))
						.build();
				// @formatter:on
			}
		});
		log.debug("mockReturn line: {}", mockReturn);
		return mockReturn;
	}

	private SqlParams generateInsertSql(String old_performance_name, String old_performance_date,
			String new_performance_name, String new_performance_date) {
		// @formatter:off
		//not sure about this sql script format
		String sql = ""
				+ "UPDATE performances "
				+ "SET performance_name = :new_performance_name, performance_date = :new_performance_date "
				+ "WHERE performance_name = :old_performance_name AND performance_date = :old_performance_date;";
		// @formatter:on

		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("new_performance_name", new_performance_name);
		params.source.addValue("new_performance_date", new_performance_date);
		params.source.addValue("old_performance_name", old_performance_name);
		params.source.addValue("old_performance_date", old_performance_date);

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
				+ "WHERE performance_name = :performance_name "
				+ "AND performance_date = :performance_date;";
		// @formatter:on
		return sql;
	}

	private Map<String, Object> getParams(String performance_name, String performance_date) {
		Map<String, Object> params = new HashMap<>();
		params.put("performance_name", performance_name);
		params.put("performance_date", performance_date);
		return params;

	}

}
