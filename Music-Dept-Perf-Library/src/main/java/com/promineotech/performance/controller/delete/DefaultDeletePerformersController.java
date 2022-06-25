package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.DeletePerformer;
import com.promineotech.performance.entity.Performers;
import com.promineotech.performance.service.delete.DeletePerformersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeletePerformersController implements DeletePerformersController {
	@Autowired
	private DeletePerformersService deletePerformersService;
	
	@Override
	public List<Performers> deletePerformers(@Valid DeletePerformer deletePerformers) {
		log.debug("deletePerformance:{}", deletePerformers);
		return deletePerformersService.deletePerformer(deletePerformers);

	}
}
