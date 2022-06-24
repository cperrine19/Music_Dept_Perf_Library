package com.promineotech.performance.dao;

import com.promineotech.performance.entity.Performances;

public interface DeletePerformanceDao {
	Performances saveDeletePerf(String performance_date, String performance_name);

}
