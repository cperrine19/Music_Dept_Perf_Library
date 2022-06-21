package com.promineotech.performance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.service.PerformanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPerformanceController implements PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;

	@Override
	public List<Performances> fetchPerformances(String date) {
		log.debug("date={}", date);
		return performanceService.fetchPerformances(date);
	}

}
