package com.promineotech.performance.service;

import javax.validation.Valid;

import com.promineotech.performance.entity.DeletePerformance;
import com.promineotech.performance.entity.Performances;

public interface DeletePerformanceService {

	Performances deletePerformance(@Valid DeletePerformance deletePerf);
	

}
