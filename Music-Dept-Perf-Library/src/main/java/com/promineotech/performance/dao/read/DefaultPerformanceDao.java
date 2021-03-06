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

import com.promineotech.performance.entity.Performances;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPerformanceDao implements PerformanceDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Performances> fetchPerformances(String date, String name) {
		log.info("The fetchPeformances method was called with date={} and name={}", date, name);
		
		// formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM performances "
			+ "WHERE performance_date = :performance_date OR performance_name = :performance_name";
		// formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("performance_date", date);
		params.put("performance_name", name);
		
		// ((date != null) ? date : "")
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Performances mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Performances.builder()
					.performance_pk(rs.getInt("performance_pk"))
					.performance_name(rs.getString("performance_name"))
					.performance_date(rs.getString("performance_date"))
					.build();
				// @formatter:on
			}
		});
	}

}
