package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Performers;
import com.promineotech.performance.service.read.PerformersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPerformersController implements PerformersController {
	
	@Autowired
	private PerformersService performersService;
	
	@Override
	public List<Performers> fetchPerformers(String first_name, String last_name) {
		log.debug("the fetchPerformers method was called with first_name={} and last_name{}", first_name, last_name);
		return performersService.fetchPerformers(first_name, last_name);
	}

}
