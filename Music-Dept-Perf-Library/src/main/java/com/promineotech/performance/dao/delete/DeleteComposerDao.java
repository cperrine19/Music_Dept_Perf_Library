package com.promineotech.performance.dao.delete;

import java.util.List;

import com.promineotech.performance.entity.Composer;

public interface DeleteComposerDao {
	List<Composer> saveComposer(String first_name, String last_name);

}
