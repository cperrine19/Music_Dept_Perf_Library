package com.promineotech.performance.controller.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.DeleteComposer;
import com.promineotech.performance.service.delete.DeleteComposerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultDeleteComposerController implements DeleteComposerController{

	@Autowired
	private DeleteComposerService deleteComposerService;
	
	@Override
	public List<Composer> deleteComposer(@Valid DeleteComposer deleteComp) {
		log.debug("deleteComposer:{}", deleteComp);

		return deleteComposerService.deleteComposer(deleteComp);
	}

}
