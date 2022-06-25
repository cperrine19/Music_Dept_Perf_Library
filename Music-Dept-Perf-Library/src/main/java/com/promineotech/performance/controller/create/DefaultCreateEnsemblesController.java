package com.promineotech.performance.controller.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.CreateEnsembles;
import com.promineotech.performance.entity.Ensembles;
import com.promineotech.performance.service.create.CreateEnsemblesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCreateEnsemblesController implements CreateEnsemblesController {

	@Autowired
	private CreateEnsemblesService createEnsemblesService;
	
	@Override
	public Ensembles createEnsembles(CreateEnsembles createEns) {
		log.debug("createEnsembles:{}, createEns");
		return createEnsemblesService.createEnsembles(createEns);
	}
}
