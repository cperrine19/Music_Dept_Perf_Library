package com.promineotech.performance.dao.read;

import java.util.List;

import com.promineotech.performance.entity.Composer;

public interface ComposersDao {
	List<Composer> fetchComposers(String first_name, String last_name);

}
