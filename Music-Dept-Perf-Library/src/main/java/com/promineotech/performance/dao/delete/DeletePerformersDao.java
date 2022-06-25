package com.promineotech.performance.dao.delete;

import java.util.List;

import com.promineotech.performance.entity.Performers;

public interface DeletePerformersDao {

	List<Performers> saveDeletePerformers(String first_name, String last_name);
	}


