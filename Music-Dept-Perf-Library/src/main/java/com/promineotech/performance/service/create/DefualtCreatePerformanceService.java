package com.promineotech.performance.service.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.create.CreatePerformanceDao;
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
		String performance_name = create.getPerformance_name();
		String performance_date = create.getPerformance_date();
		return createPerformanceDao.savePerformance(performance_date, performance_name); 

		
		
	}

	//private String getPerformanceDate(CreatePerformance create) {
		//return null;
	//}

	//private String getPerformanceName(CreatePerformance create) {
		//return null;
	//}
}