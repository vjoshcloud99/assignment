package com.frequency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frequency.entity.Period;
import com.frequency.repository.PeriodRepository;

@RestController
public class FrequencyRESTController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PeriodRepository repository;

	@GetMapping(path = "/id")
	public Period getPeriodById(Long id) {
		Period period = repository.findByBusinessYearId(id);
		return period;
	}

}
