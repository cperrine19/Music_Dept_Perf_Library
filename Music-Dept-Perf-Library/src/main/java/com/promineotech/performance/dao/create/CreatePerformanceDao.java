package com.promineotech.performance.dao.create;

import com.promineotech.performance.entity.Performances;

public interface CreatePerformanceDao {

	//in homework this is copy/paste form the source folder per instructions on step 11 of week 16

	Performances savePerformance(String performance_date, String performance_name);
}
