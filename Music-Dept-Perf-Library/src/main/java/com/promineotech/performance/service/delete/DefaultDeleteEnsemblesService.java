package com.promineotech.performance.service.delete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.performance.dao.delete.DeleteEnsemblesDao;
import com.promineotech.performance.entity.DeleteEnsemble;
import com.promineotech.performance.entity.Ensembles;

@Service
public class DefaultDeleteEnsemblesService implements DeleteEnsemblesService{

	@Autowired
	private DeleteEnsemblesDao deleteEnsemblesDao;
	
	@Override
	public List<Ensembles> deleteEnsembles(DeleteEnsemble deleteEns) {
		String ensemble_name = deleteEns.getEnsemble_name();
		int member_size = deleteEns.getMember_size();
		return deleteEnsemblesDao.saveDeleteEns(ensemble_name, member_size);
	}

}
