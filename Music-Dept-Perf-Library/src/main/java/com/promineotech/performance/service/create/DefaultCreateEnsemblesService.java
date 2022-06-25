package com.promineotech.performance.service.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.create.CreateEnsemblesDao;
import com.promineotech.performance.entity.CreateEnsembles;
import com.promineotech.performance.entity.Ensembles;

@Service
public class DefaultCreateEnsemblesService implements CreateEnsemblesService {
	@Autowired
	private CreateEnsemblesDao createEnsemblesDao;

	@Transactional
	@Override

	public Ensembles createEnsembles(CreateEnsembles createEns) {
		String ensemble_name = createEns.getEnsemble_name();
		int member_size = createEns.getMember_size();
		return createEnsemblesDao.saveEnsembles(ensemble_name, member_size);
	}

}
