package com.promineotech.performance.service.read;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.read.PerformanceDao;
import com.promineotech.performance.entity.Performances;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPerformanceService implements PerformanceService {
	
	@Autowired
	private PerformanceDao performanceDao;

	@Transactional
	@Override
	public List<Performances> fetchPerformances(String date, String name) {
		log.debug("The fetchPeformances method was called with date={} and name={}", date, name);
		List<Performances> performances = performanceDao.fetchPerformances(date, name);
		
		if (performances.isEmpty()) {
			String msg = String.format("No performances found with date=%s and name=%s", date, name);
			throw new NoSuchElementException(msg);
		}
		
		return performances;
	}
}
