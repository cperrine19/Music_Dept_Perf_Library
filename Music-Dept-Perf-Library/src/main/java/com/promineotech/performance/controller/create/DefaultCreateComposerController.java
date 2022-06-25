package com.promineotech.performance.controller.create;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.CreateComposer;
import com.promineotech.performance.service.create.CreateComposerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCreateComposerController implements CreateComposerController {

	@Autowired
	private CreateComposerService createComposerService;

	@Override
	public Composer createComposer(@Valid CreateComposer createComposer) {
		log.debug("createComposer:{}", createComposer);

		return createComposerService.createComposer(createComposer);
	}

}
