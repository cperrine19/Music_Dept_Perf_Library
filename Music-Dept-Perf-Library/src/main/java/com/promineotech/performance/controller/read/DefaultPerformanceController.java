package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.service.read.PerformanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPerformanceController implements PerformanceController {
	
	@Autowired
	private PerformanceService performanceService;

	@Override
	public List<Performances> fetchPerformances(String date, String name) {
		log.debug("The fetchPeformances method was called with date={} and name={}", date, name);
		return performanceService.fetchPerformances(date, name);
	}

}
