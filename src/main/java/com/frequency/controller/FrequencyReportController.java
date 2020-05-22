package com.frequency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.frequency.service.FrequencyReportService;

@RestController
public class FrequencyReportController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private  FrequencyReportService reportService;
	
	
	
	
	

}
