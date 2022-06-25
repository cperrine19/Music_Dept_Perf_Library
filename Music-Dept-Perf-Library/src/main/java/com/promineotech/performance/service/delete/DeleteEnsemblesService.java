package com.promineotech.performance.service.delete;

import java.util.List;

import javax.validation.Valid;

import com.promineotech.performance.entity.DeleteEnsemble;
import com.promineotech.performance.entity.Ensembles;

public interface DeleteEnsemblesService {

	List<Ensembles> deleteEnsembles(@Valid DeleteEnsemble deleteEns);
}
