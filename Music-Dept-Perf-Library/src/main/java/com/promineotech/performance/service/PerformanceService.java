package com.promineotech.performance.service;

import java.util.List;

import com.promineotech.performance.entity.Performance;

public interface PerformanceService {

	List<Performance> fetchPerformances(String date);

}
