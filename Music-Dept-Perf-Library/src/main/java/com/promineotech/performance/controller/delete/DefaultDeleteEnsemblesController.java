package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.DeleteEnsemble;
import com.promineotech.performance.entity.Ensembles;
import com.promineotech.performance.service.delete.DeleteEnsemblesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeleteEnsemblesController implements DeleteEnsemblesController {

	@Autowired
	private DeleteEnsemblesService deleteEnsemblesService;

	@Override
	public List<Ensembles> deleteEnsemble(@Valid DeleteEnsemble deleteEns) {
		log.debug("deleteEnsemble:{}", deleteEns);
		return deleteEnsemblesService.deleteEnsembles(deleteEns);
	}

}
