package com.promineotech.performance.service.create;

import javax.validation.Valid;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.CreateComposer;

public interface CreateComposerService {

	Composer createComposer(@Valid CreateComposer createComposer);

}
