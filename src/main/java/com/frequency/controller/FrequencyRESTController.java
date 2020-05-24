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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frequency.entity.Cycle;
import com.frequency.service.CycleService;

@RestController
public class FrequencyRESTController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CycleService cycleService;

	/*@Autowired
	private FrequencyService frequencyService;*/

	/*@Autowired
	private PeriodService periodService;*/


	@PostMapping("/cycles" )
	public  ResponseEntity<String>  prepareCycleData( @RequestParam("businessYearId") Long businessYearId,
													 @RequestParam("frequencyId") Long frequencyId) {

		cycleService.prepareCycleData(businessYearId, frequencyId);

		return new ResponseEntity<String>("Succefully Generated Cycle Data",HttpStatus.OK);
	}

	@GetMapping("cycles/period/{businessyearid}/frequency/{frequencyid}" )
	public  ResponseEntity<List<Cycle>>  findByPeriodAndFrequency(@PathVariable("businessYearId") Long businessYearId,
													 @PathVariable("frequencyId") Long frequencyId) {

		List<Cycle> cycles = cycleService.findByPeriodAndFrequency(businessYearId, frequencyId);

		return new ResponseEntity<>(cycles, HttpStatus.OK);
	}

	@GetMapping(path = "/cycles/businessid/{id}")
	public ResponseEntity<List<Cycle>> findCyclesByBusinessYearId(@PathVariable("id") Long businessYearId) {

		List<Cycle> cycles = cycleService.findByBusinessYearId(businessYearId);

		return new ResponseEntity<>(cycles, HttpStatus.OK);
	}


	@GetMapping(path = "/cycles/frequencies/{frequencyId}")
	public ResponseEntity<List<Cycle>> findCyclesByFrequencyId(@PathVariable("frequencyId") Long frequencyId) {

		List<Cycle> cycles = cycleService.findByFrequencyId(frequencyId);

		return new ResponseEntity<>(cycles, HttpStatus.OK);
	}
}
