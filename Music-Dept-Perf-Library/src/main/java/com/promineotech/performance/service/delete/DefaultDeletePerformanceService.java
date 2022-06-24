package com.promineotech.performance.service.delete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.delete.DeletePerformanceDao;
import com.promineotech.performance.entity.DeletePerformance;
import com.promineotech.performance.entity.Performances;

@Service
public class DefaultDeletePerformanceService implements DeletePerformanceService {
	
	
	@Autowired
	private DeletePerformanceDao deletePerformanceDao;
	
	@Transactional
	@Override
	public List<Performances> deletePerformance(DeletePerformance deletePerf) {
		String performance_name = deletePerf.getPerformance_name();
		String performance_date = deletePerf.getPerformance_date();
		return deletePerformanceDao.saveDeletePerf(performance_date, performance_name);
	
	}
}