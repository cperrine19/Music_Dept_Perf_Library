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

import com.promineotech.performance.entity.Composer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultDeleteComposerDao implements DeleteComposerDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Transactional
	@Override
	public List<Composer> saveComposer(String first_name, String last_name) {
		SqlParams params = generateInsertSql(first_name, last_name);

		KeyHolder keyHolder = new GeneratedKeyHolder(); // step 15bii
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		String sql2 = checkSql();
		Map<String, Object> params2 = getParams(first_name, last_name);
		// @formatter:off
		List<Composer> mockReturn = jdbcTemplate.query(sql2, params2, new RowMapper<>() {
			@Override
			public Composer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter:off
				
				return Composer.builder()
				.composer_pk(rs.getInt("composer_pk"))
				.first_name(rs.getString("first_name"))
				.last_name(rs.getString("last_name"))
				.build();
		 	// @formatter:on;
			}
		});
		log.debug("mockReturn line: {}", mockReturn);
		return mockReturn;
	}
		
		private Map<String, Object> getParams(String first_name, String last_name) {
			Map<String, Object> params = new HashMap<>();
			params.put("first_name", first_name);
			params.put("last_name", last_name);
			return params;
		}


	private SqlParams generateInsertSql(String first_name, String last_name) {
		// @formatter:off
		String sql = ""
				+ "DELETE FROM composers "
				+ "WHERE first_name = :first_name "
				+ "AND last_name = :last_name;";
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

	private String checkSql() {
		// @formatter:off
		String sql = ""
				+ "SELECT * FROM composers "
				+ "WHERE first_name = :first_name "
				+ "AND last_name = :last_name;";
		// @formatter:on
		return sql;
	}

	}

