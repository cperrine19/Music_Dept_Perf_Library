package com.promineotech.performance.dao.read;

import java.util.List;

import com.promineotech.performance.entity.Performers;

public interface PerformersDao {
	List<Performers> fetchPerformers(String first_name, String last_name);
}
