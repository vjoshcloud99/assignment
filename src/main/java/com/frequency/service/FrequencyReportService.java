package com.frequency.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.frequency.entity.Period;

@Service
public interface FrequencyReportService extends JpaRepository<Period, Long> {
	
	
	
	
	

}
