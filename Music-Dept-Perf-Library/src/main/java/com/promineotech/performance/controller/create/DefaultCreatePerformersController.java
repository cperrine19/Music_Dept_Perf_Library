package com.promineotech.performance.controller.create;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.CreatePerformer;
import com.promineotech.performance.entity.Performers;
import com.promineotech.performance.service.create.CreatePerformersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCreatePerformersController implements CreatePerformersController {

	@Autowired
	private CreatePerformersService createPerformersService;

	@Override
	public Performers createPerformer(@Valid CreatePerformer createPerformer) {
		log.debug("createPerformer:{}", createPerformer);

		return createPerformersService.createPerformer(createPerformer);
	}

}
