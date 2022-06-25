package com.promineotech.performance.service.update;

import java.util.List;

import javax.validation.Valid;

import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.entity.UpdatePerformance;

public interface UpdatePerformanceService {

	List<Performances> updatePerformance(@Valid UpdatePerformance oldPerformance,
			@Valid UpdatePerformance newPerformance);

}
