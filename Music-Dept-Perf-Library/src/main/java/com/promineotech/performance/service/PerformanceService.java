package com.promineotech.performance.service;

import java.util.List;

import com.promineotech.performance.entity.Performances;

public interface PerformanceService {

	List<Performances> fetchPerformances(String date, String name);

}
