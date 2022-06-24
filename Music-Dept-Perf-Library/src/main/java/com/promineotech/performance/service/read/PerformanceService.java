package com.promineotech.performance.service.read;

import java.util.List;

import com.promineotech.performance.entity.Performances;

public interface PerformanceService {

	List<Performances> fetchPerformances(String date, String name);

}
