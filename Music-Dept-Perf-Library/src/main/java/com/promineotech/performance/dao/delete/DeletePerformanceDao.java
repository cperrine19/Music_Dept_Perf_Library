package com.promineotech.performance.dao.delete;

import java.util.List;

import com.promineotech.performance.entity.Performances;

public interface DeletePerformanceDao {
	List<Performances> saveDeletePerf(String performance_date, String performance_name);

}