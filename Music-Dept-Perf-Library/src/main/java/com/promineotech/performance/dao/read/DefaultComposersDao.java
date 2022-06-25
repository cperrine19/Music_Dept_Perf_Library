package com.promineotech.performance.dao.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.promineotech.performance.entity.Composer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultComposersDao implements ComposersDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Composer> fetchComposers(String first_name, String last_name) {
		log.info("The fetchComposers method was called with first_name={} and last_name={}", first_name, last_name);
		// formatter:off
				String sql = ""
					+ "SELECT * "
					+ "FROM composers "
					+ "WHERE first_name = :first_name OR last_name = :last_name";
				// formatter:on
				Map<String, Object> params = new HashMap<>();
				params.put("first_name", first_name);
				params.put("last_name", last_name);
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public Composer mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Composer.builder()
					.composer_pk(rs.getInt("composer_pk"))
					.first_name(rs.getString("first_name"))
					.last_name(rs.getString("last_name"))
					.build();
				// @formatter:on
			}
		});
	}

}

