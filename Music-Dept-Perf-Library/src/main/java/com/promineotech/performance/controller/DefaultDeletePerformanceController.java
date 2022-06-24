package com.promineotech.performance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.DeletePerformance;
import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.service.DeletePerformanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeletePerformanceController implements DeletePerformanceController{
	
	@Autowired
	private DeletePerformanceService deletePerformanceService;

	@Override
	public Performances deletePerformance(@Valid DeletePerformance deletePerf) {
		log.debug("deletePerformance:{}", deletePerf);
		return deletePerformanceService.deletePerformance(deletePerf);
	}

}
