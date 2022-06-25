package com.promineotech.performance.service.update;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.update.UpdatePerformanceDao;
import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.entity.UpdatePerformance;

public class DefaultUpdatePerformanceService implements UpdatePerformanceService {

	@Autowired
	private UpdatePerformanceDao updatePerformanceDao;

	@Transactional
	@Override
	public List<Performances> updatePerformance(@Valid UpdatePerformance oldPerformance,
			@Valid UpdatePerformance newPerformance) {
		String old_performance_name = oldPerformance.getPerformance_name();
		String old_performance_date = oldPerformance.getPerformance_date();
		String new_performance_name = newPerformance.getPerformance_name();
		String new_performance_date = newPerformance.getPerformance_date();
		return updatePerformanceDao.updatePerformance(old_performance_name, old_performance_date, new_performance_name,
				new_performance_date);
	}

}
