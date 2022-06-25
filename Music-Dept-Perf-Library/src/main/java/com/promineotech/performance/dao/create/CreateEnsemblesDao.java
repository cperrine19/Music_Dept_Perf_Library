package com.promineotech.performance.dao.create;

import com.promineotech.performance.entity.Ensembles;

public interface CreateEnsemblesDao {

	Ensembles saveEnsembles(String ensemble_name, int member_size);
}
