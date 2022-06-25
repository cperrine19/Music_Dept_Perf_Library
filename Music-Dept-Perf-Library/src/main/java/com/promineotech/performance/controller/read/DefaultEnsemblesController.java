package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Ensembles;
import com.promineotech.performance.service.read.EnsemblesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEnsemblesController implements EnsemblesController{
	
	@Autowired
	private EnsemblesService ensembleService;
	

	@Override
	public List<Ensembles> fetchEnsembles(String ensemble_name, int member_size) {
		log.debug("The fetchEnsembles method was called with ensemble={} and size={} ", ensemble_name, member_size);
		return ensembleService.fetchEnsembles(ensemble_name, member_size);
	}

}
