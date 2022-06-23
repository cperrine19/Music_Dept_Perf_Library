package com.promineotech.performance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.CreatePerformance;
import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.service.CreatePerformanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCreatePerformanceController implements CreatePerformanceController {

	//this is step 4 in week 16
	
	@Autowired
	private CreatePerformanceService createPerformanceService;

	@Override
	public Performances createPerformance(@Valid CreatePerformance create) {
		// TODO Auto-generated method stub
		log.debug("createPerformance:{}", create);
		return createPerformanceService.createPerformance(create); //check this-
	}

}
