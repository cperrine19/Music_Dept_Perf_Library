package com.promineotech.performance.service.read;

import java.util.List;

import com.promineotech.performance.entity.Ensembles;

public interface EnsemblesService {
	
	List<Ensembles> fetchEnsembles(String ensemble_name, int member_size);

}
