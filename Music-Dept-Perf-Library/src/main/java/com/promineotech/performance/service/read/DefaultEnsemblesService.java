package com.promineotech.performance.service.read;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.read.EnsemblesDao;
import com.promineotech.performance.entity.Ensembles;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEnsemblesService implements EnsemblesService{
	
	@Autowired
	private EnsemblesDao ensemblesDao;
	
	@Transactional
	@Override
	public List<Ensembles> fetchEnsembles(String ensemble_name, int member_size) {
		log.debug("The fetchEnsembles method was called with name={} and size={}", ensemble_name, member_size);
		List<Ensembles> ensembles = ensemblesDao.fetchEnsembles(ensemble_name, member_size);
		
		if(ensembles.isEmpty()) {
			String msg = String.format("No ensembles were found with ensemble_name=%s and member_size=%s", ensemble_name, member_size);
			throw new NoSuchElementException(msg);
		}
		return ensembles;
		
	}

}
