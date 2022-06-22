package com.promineotech.performance.dao;

import java.util.List;

import com.promineotech.performance.entity.Performance;

public interface PerformanceDao {
	
	List<Performance> fetchPerformances(String date);
	
}
