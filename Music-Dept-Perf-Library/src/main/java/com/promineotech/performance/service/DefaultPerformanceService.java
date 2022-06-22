package com.promineotech.performance.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.performance.dao.PerformanceDao;
import com.promineotech.performance.entity.Performance;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPerformanceService implements PerformanceService {
	
	@Autowired
	private PerformanceDao performanceDao;

	public List<Performance> fetchPerformances(String date) {
		log.info("The fetchPeformances method was called with date={}", date);
		List<Performance> performances = performanceDao.fetchPerformances(date);
		
		if (performances.isEmpty()) {
			String msg = String.format("No performances found with date={}", date);
			throw new NoSuchElementException(msg);
		}
		
		return performances;
	}
}
