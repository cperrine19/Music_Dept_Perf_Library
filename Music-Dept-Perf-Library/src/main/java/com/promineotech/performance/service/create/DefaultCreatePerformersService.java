package com.promineotech.performance.service.create;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.performance.dao.create.CreatePerformersDao;
import com.promineotech.performance.entity.CreatePerformer;
import com.promineotech.performance.entity.Performers;

@Service
public class DefaultCreatePerformersService implements CreatePerformersService {
	
	@Autowired
	private CreatePerformersDao createPerformersDao;

	@Override
	public Performers createPerformer(@Valid CreatePerformer createPerformer) {
		String first_name = createPerformer.getFirst_name();
		String last_name = createPerformer.getLast_name();
		return createPerformersDao.savePerformer(first_name, last_name);
	}

}
