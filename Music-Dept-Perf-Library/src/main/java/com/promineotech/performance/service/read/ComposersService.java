package com.promineotech.performance.service.read;

import java.util.List;

import com.promineotech.performance.entity.Composer;

public interface ComposersService {

	List<Composer> fetchComposers(String first_name, String last_name);

}
