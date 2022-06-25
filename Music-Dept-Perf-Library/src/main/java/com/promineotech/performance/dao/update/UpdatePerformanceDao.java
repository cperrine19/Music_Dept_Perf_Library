package com.promineotech.performance.dao.update;

import java.util.List;

import com.promineotech.performance.entity.Performances;

public interface UpdatePerformanceDao {

	List<Performances> updatePerformance(String old_performance_name, String old_performance_date,
			String new_performance_name, String new_performance_date);

}
