package com.promineotech.performance.service.read;

import java.util.List;

import com.promineotech.performance.entity.Performers;

public interface PerformersService {

	List<Performers> fetchPerformers(String first_name, String last_name);

}
