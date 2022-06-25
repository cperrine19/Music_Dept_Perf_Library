package com.promineotech.performance.service.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.delete.DeletePerformersDao;
import com.promineotech.performance.entity.DeletePerformer;
import com.promineotech.performance.entity.Performers;

@Service
public class DefaultDeletePerformersService implements DeletePerformersService {

	@Autowired
	private DeletePerformersDao deletePerformersDao;
	
	@Transactional
	@Override
	public List<Performers> deletePerformer(@Valid DeletePerformer deletePerformers) {
		String first_name = deletePerformers.getFirst_name();
		String last_name = deletePerformers.getLast_name();
		return deletePerformersDao.saveDeletePerformers(first_name, last_name);
	}

}
