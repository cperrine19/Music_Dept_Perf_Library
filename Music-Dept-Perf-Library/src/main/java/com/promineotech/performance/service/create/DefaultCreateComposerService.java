package com.promineotech.performance.service.create;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.create.CreateComposerDao;
import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.CreateComposer;

@Service
public class DefaultCreateComposerService implements CreateComposerService{
	@Autowired
	private CreateComposerDao createComposerDao;

	@Transactional
	@Override
	public Composer createComposer(@Valid CreateComposer createComposer) {
		String first_name = createComposer.getFirst_name();
		String last_name = createComposer.getLast_name();
		return createComposerDao.saveComposer(first_name, last_name);
	}

}
