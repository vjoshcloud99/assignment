package com.frequency.service;

import java.util.List;

import com.frequency.entity.Cycle;

public interface CycleService {
	
	void prepareCycleData(Long businessYearId, Long frequencyId);
	
	List<Cycle> findCyclesForFrequency();

}
