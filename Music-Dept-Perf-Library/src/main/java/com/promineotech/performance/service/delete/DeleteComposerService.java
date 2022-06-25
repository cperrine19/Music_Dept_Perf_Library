package com.promineotech.performance.service.delete;

import java.util.List;

import javax.validation.Valid;

import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.DeleteComposer;

public interface DeleteComposerService {

	List<Composer> deleteComposer(@Valid DeleteComposer deleteComp);
	

}
