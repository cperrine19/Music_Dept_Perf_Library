package com.promineotech.performance.dao.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.entity.Performers;

@Component
public class DefaultCreatePerformersDao implements CreatePerformersDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public Performers savePerformer(String first_name, String last_name) {
		SqlParams params = generateInsertSql(first_name, last_name);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		// @formatter:off
		return Performers.builder()
				.first_name(first_name)
				.last_name(last_name)
				.build();
		// @formatter:on;
	}

	private SqlParams generateInsertSql(String first_name, String last_name) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO performers ("
				+ "first_name, last_name"
				+") VALUES ("
				+ ":first_name, :last_name"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("first_name", first_name);
		params.source.addValue("last_name", last_name);

		return params;
	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
}
