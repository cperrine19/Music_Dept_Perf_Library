package com.promineotech.performance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.CreatePerformanceDao;
import com.promineotech.performance.entity.CreatePerformance;
import com.promineotech.performance.entity.Performances;

@Service
public class DefualtCreatePerformanceService implements CreatePerformanceService {
	
	@Autowired
	private CreatePerformanceDao createPerformanceDao;

	
	@Transactional
	@Override
	public Performances createPerformance(CreatePerformance create) {
		//step 8c in week16 homework
		Performances performance_name = getPerformanceName(create);
		Performances performance_date = getPerformanceDate(create);
		return createPerformanceDao.savePerformance("performance_date", "performance_name"); 

		
		
	}

	private Performances getPerformanceDate(CreatePerformance create) {
		// TODO Auto-generated method stub
		return null;
	}

	private Performances getPerformanceName(CreatePerformance create) {
		// TODO Auto-generated method stub
		return null;
	}
}