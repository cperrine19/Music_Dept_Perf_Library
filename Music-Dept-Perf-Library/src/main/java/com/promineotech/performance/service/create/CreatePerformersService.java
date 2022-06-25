package com.promineotech.performance.service.create;

import javax.validation.Valid;

import com.promineotech.performance.entity.CreatePerformer;
import com.promineotech.performance.entity.Performers;

public interface CreatePerformersService {

	Performers createPerformer(@Valid CreatePerformer createPerformer);

}
