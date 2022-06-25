package com.promineotech.performance.dao.create;

import com.promineotech.performance.entity.Composer;

public interface CreateComposerDao {
	Composer saveComposer(String first_name, String last_name);
}
