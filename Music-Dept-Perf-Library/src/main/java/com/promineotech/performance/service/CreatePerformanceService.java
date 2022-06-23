package com.promineotech.performance.service;

import com.promineotech.performance.entity.CreatePerformance;
import com.promineotech.performance.entity.Performances;

public interface CreatePerformanceService {
	Performances createPerformance(CreatePerformance create);
	//createPerformance is the same as createOrder in Jeeps
	//CreatePerformance is the same as OrderRequest in Jeeps
	//create is the same as request in Jeeps
}


