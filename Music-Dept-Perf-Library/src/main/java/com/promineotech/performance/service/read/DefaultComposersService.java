package com.promineotech.performance.service.read;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.performance.dao.read.ComposersDao;
import com.promineotech.performance.entity.Composer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultComposersService implements ComposersService {

	@Autowired
	private ComposersDao composersDao;

	@Override
	public List<Composer> fetchComposers(String first_name, String last_name) {
		log.debug("The fetchComposers method was called with first_name={} or last_name={}", first_name, last_name);
		List<Composer> composers = composersDao.fetchComposers(first_name, last_name);
		if (composers.isEmpty()) {
			String msg = String.format("No composers found with first_name=%s or last_name=%s", first_name, last_name);
			throw new NoSuchElementException(msg);
		}
		return composers;
	}

}
