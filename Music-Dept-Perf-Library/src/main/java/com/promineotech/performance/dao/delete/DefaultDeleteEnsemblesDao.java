package com.promineotech.performance.dao.delete;

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

import com.promineotech.performance.entity.Ensembles;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDeleteEnsemblesDao implements DeleteEnsemblesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public List<Ensembles> saveDeleteEns(String ensemble_name, int member_size) {
		SqlParams params = generateInsertSql(ensemble_name, member_size);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		String sql2 = checkSql();
		Map<String, Object> params2 = getParams(ensemble_name, member_size);
		// @formatter:off
		List<Ensembles> mockReturn = jdbcTemplate.query(sql2, params2, new RowMapper<>() {
			@Override
			public Ensembles mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter:off
				
				return Ensembles.builder()
				.ensemble_pk(rs.getInt("ensemble_pk"))
				.ensemble_name(rs.getString("ensemble_name"))
				.member_size(rs.getInt("member_size"))
				.build();
		 	// @formatter:on;

			}
		});
		log.debug("mockReturn line: {}", mockReturn);
		return mockReturn;
	}

	private Map<String, Object> getParams(String ensemble_name, int member_size) {
		Map<String, Object> params = new HashMap<>();
		params.put("ensemble_name", ensemble_name);
		params.put("member_size", member_size);
		return params;
	}

	private SqlParams generateInsertSql(String ensemble_name, int member_size) {
		// @formatter:off
		String sql = ""
				+ "DELETE FROM ensembles "
				+ "WHERE ensemble_name = :ensemble_name "
				+ "AND member_size = :member_size;";
		// @formatter:on

		SqlParams params = new SqlParams();
		params.sql = sql;
		params.source.addValue("ensemble_name", ensemble_name);
		params.source.addValue("member_size", member_size);

		return params;

	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	private String checkSql() {
		// @formatter:off
			String sql = ""
					+ "SELECT * FROM ensembles "
					+ "WHERE ensemble_name = :ensemble_name "
					+ "AND member_size = :member_size;";
			// @formatter:on
		return sql;
	}
}
