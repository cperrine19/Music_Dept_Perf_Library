package com.promineotech.performance.controller.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.service.read.ComposersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultComposersController implements ComposersController{
	@Autowired
	private ComposersService composersService;

	@Override
	public List<Composer> fetchComposers(String first_name, String last_name) {
		log.debug("The fetchComposers method was called with first_name={} and last_name{}", first_name, last_name);
		return composersService.fetchComposers(first_name, last_name);
	}
	


}
