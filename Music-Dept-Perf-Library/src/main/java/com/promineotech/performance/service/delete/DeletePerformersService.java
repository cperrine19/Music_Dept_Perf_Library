package com.promineotech.performance.service.delete;

import java.util.List;

import javax.validation.Valid;

import com.promineotech.performance.entity.DeletePerformer;
import com.promineotech.performance.entity.Performers;

public interface DeletePerformersService {

	List<Performers> deletePerformer(@Valid DeletePerformer deletePerformers);

}
