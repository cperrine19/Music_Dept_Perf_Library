package com.promineotech.performance.dao.create;

import com.promineotech.performance.entity.Performers;

public interface CreatePerformersDao {
	Performers savePerformer(String first_name, String last_name);

}
