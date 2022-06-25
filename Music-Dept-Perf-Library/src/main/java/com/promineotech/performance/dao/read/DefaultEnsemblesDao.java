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

import com.promineotech.performance.entity.Ensembles;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEnsemblesDao implements EnsemblesDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Ensembles> fetchEnsembles(String ensemble_name, int member_size) {
		log.info("The fetchEnsembles method was called with name={} and size={}", ensemble_name, member_size);
		
		// formatter:off
		String sql = "" 
				+ "SELECT * " 
				+ "FROM ensembles "
				+ "WHERE ensemble_name = :ensemble_name or member_size = :member_size";
		// formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("ensemble_name", ensemble_name);
		params.put("member_size", member_size);

		// ((date != null) ? date : "")

		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Ensembles mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Ensembles.builder()
					.ensemble_pk(rs.getInt("ensemble_pk"))
					.ensemble_name(rs.getString("ensemble_name"))
					.member_size(rs.getInt("member_size"))
					.build();
				// @formatter:on
			}
		});
	}

}
