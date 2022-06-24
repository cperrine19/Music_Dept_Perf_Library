package com.promineotech.performance.dao.read;

import java.util.List;

import com.promineotech.performance.entity.Performances;

public interface PerformanceDao {
	
	List<Performances> fetchPerformances(String date, String name);
	
}
