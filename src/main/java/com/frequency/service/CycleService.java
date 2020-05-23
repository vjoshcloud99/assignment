package com.frequency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frequency.entity.Cycle;
import com.frequency.entity.Frequency;
import com.frequency.entity.Period;

@Service
public interface CycleService {
	
	List<Cycle> prepareCycleData(Period  period, Frequency frequency);

}
