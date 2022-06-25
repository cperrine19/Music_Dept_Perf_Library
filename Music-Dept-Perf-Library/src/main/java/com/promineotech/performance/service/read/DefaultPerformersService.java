package com.promineotech.performance.service.read;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.performance.dao.read.PerformersDao;
import com.promineotech.performance.entity.Performers;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPerformersService implements PerformersService{
	
	@Autowired
	private PerformersDao performersDao;
	
	@Transactional
	@Override
	public List<Performers> fetchPerformers(String first_name, String last_name) {
		log.debug("The fetchPeformers method was called with first_name={} and last_name={}", first_name, last_name);
		List<Performers> performers = performersDao.fetchPerformers(first_name, last_name);
		
		if (performers.isEmpty()) {
			String msg = String.format("No performers found with first_name=%s and last_name=%s", first_name, last_name);
			throw new NoSuchElementException(msg);
		}
		return performers;
	}

}
