package com.promineotech.performance.dao.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.entity.Ensembles;

@Component
public class DefaultCreateEnsemblesDao implements CreateEnsemblesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public Ensembles saveEnsembles(String ensemble_name, int member_size) {
		SqlParams params = generateInsertSql(ensemble_name, member_size);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		// @formatter:off
				return Ensembles.builder()
						.ensemble_name(ensemble_name)
						.member_size(member_size)
						.build();
		// @formatter:on;
	}

	private SqlParams generateInsertSql(String ensemble_name, int member_size) {
		// @formatter:off
		String sql = ""
				+ "INSERT INTO ensembles ("
				+ "ensemble_name, member_size"
				+") VALUES ("
				+ ":ensemble_name, :member_size"
				+ ")";
		// @formatter:on
		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("ensemble_name", ensemble_name); // stuck here
		params.source.addValue("member_size", member_size); // stuck here

		return params;

	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
}
