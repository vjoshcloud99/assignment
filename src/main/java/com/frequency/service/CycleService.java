package com.frequency.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.frequency.entity.Cycle;

public interface CycleService {

	List<Cycle> findByPeriodAndFrequency(Long businessYearId, Long frequencyId);
	List<Cycle> findByBusinessYearId(Long businessYearId);
	
	//@Query(value = "select * from cycle  where frequency_id=?",nativeQuery = true )
	List<Cycle> findByFrequencyId(Long frequencyId);
	void prepareCycleData(Long businessYearId, Long frequencyId);

}
