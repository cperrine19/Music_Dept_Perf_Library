package com.promineotech.performance.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.performance.entity.Performance;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPerformanceDao {

	public List<Performance> fetchPerformances(String date) {
		log.debug("The fetchPeformances method was called with date={}", date);
		return null;
	}

}
