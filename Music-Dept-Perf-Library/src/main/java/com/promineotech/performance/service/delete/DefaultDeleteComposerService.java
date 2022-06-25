package com.promineotech.performance.service.delete;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.delete.DeleteComposerDao;
import com.promineotech.performance.entity.Composer;
import com.promineotech.performance.entity.DeleteComposer;

@Service
public class DefaultDeleteComposerService implements DeleteComposerService {
	@Autowired
	private DeleteComposerDao deleteComposerDao;
	
	@Transactional
	@Override
	public List<Composer> deleteComposer(@Valid DeleteComposer deleteComp) {
		String first_Name = deleteComp.getFirst_name();
		String last_Name = deleteComp.getLast_name();
		return deleteComposerDao.saveComposer(first_Name, last_Name);
	}

}
