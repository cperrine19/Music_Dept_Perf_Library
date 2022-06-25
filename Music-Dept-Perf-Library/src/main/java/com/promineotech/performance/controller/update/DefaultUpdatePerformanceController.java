package com.promineotech.performance.controller.update;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.performance.dao.update.UpdatePerformanceDao;
import com.promineotech.performance.entity.Performances;
import com.promineotech.performance.entity.UpdatePerformance;
import com.promineotech.performance.service.update.UpdatePerformanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultUpdatePerformanceController implements UpdatePerformanceController {
	
//	@Autowired
//	private UpdatePerformanceService updatePerformanceService;

	@Autowired
	private UpdatePerformanceDao updatePerformanceDao;
	
	@Override
	public List<Performances> updatePerformance(@Valid Map<String, UpdatePerformance> performances) {
		log.info("old performance={}", performances.get("Old"));
		log.info("new performance={}", performances.get("New"));

		// log.info("oldPerformance={}, newPerformance={}", oldPerformance, newPerformance);
		// return updatePerformanceService.updatePerformance(oldPerformance, newPerformance);
		return updatePerformanceDao.updatePerformance(performances.get("Old").getPerformance_name(), 
				performances.get("Old").getPerformance_date(),
				performances.get("New").getPerformance_name(),
				performances.get("New").getPerformance_date());
	}

}
