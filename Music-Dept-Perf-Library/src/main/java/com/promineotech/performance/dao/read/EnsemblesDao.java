package com.promineotech.performance.dao.read;

import java.util.List;

import com.promineotech.performance.entity.Ensembles;

public interface EnsemblesDao {
	public List<Ensembles> fetchEnsembles(String ensemble_name, int member_size);
}
