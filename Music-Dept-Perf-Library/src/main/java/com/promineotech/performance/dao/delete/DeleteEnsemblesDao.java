package com.promineotech.performance.dao.delete;

import java.util.List;

import com.promineotech.performance.entity.Ensembles;

public interface DeleteEnsemblesDao {
	List<Ensembles> saveDeleteEns(String ensemble_name, int member_size);
}
