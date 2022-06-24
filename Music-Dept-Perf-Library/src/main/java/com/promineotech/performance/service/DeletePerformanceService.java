package com.promineotech.performance.service;

import java.util.List;

import javax.validation.Valid;

import com.promineotech.performance.entity.DeletePerformance;
import com.promineotech.performance.entity.Performances;

public interface DeletePerformanceService {

	List<Performances> deletePerformance(@Valid DeletePerformance deletePerf);
	

}