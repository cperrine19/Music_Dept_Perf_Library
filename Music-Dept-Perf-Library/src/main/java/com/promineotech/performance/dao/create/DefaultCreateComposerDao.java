package com.promineotech.performance.dao.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.performance.entity.Composer;

@Component
public class DefaultCreateComposerDao implements CreateComposerDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Composer saveComposer(String first_name, String last_name) {
		SqlParams params = generateInsertSql(first_name, last_name);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		// @formatter:off
				return Composer.builder()
						.first_name(first_name)
						.last_name(last_name)
						.build();
		// @formatter:on;
	}

	private SqlParams generateInsertSql(String first_name, String last_name) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO composers ("
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
