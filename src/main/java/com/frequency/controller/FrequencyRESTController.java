package com.frequency.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frequency.entity.Cycle;
import com.frequency.repository.CycleRepository;
import com.frequency.repository.FrequencyRepository;
import com.frequency.repository.PeriodRepository;

@RestController
public class FrequencyRESTController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PeriodRepository periodRepository;

	@Autowired
	private FrequencyRepository frequencyRepository;

	@Autowired
	private CycleRepository cycleRepository;
	
	
	@PostMapping("cycles/{businessyearid}/{frequencyid}" )
	public  ResponseEntity<String>  prepareCycleService() {
		
		
		
		return new ResponseEntity<String>("Succefully Generated Cycle Data",HttpStatus.OK);
	}

	@GetMapping(path = "/cycles/businessid/{id}")
	public ResponseEntity<List<Cycle>> findCyclesByBusinessYearId(@PathVariable("id") Long id) {

		List<Cycle> cyclesList = cycleRepository.findByBusinessYearId(id);

		return new ResponseEntity<List<Cycle>>(cyclesList, HttpStatus.OK);
	}
	

	
	@GetMapping(path = "/cycles/frequencies/{id}")
	public ResponseEntity<List<Cycle>> findCyclesByFrequencyId(@PathVariable("id") Long id) {

		List<Cycle> cyclesList = cycleRepository.findByFrequencyId(id);

		return new ResponseEntity<List<Cycle>>(cyclesList, HttpStatus.OK);
	}
}
