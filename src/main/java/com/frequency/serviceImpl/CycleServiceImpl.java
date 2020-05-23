package com.frequency.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frequency.entity.Cycle;
import com.frequency.entity.Frequency;
import com.frequency.entity.Period;
import com.frequency.repository.CycleRepository;
import com.frequency.service.CycleService;

public class CycleServiceImpl implements CycleService {
	

	@Autowired
	private CycleRepository cycleRepository;

	@Override
	public List<Cycle> prepareCycleData(Period period, Frequency frequency) {
		
		List<Cycle> cyclesList=new ArrayList<>();
		Cycle cycle = new Cycle();
		cycle.setBusinessYearId(period);
		cycle.setFrequencyId(frequency);
		cycle.setPeriodName("week 1");
		cycle.setFromDate(new Date(2020-01-01));
		cycle.setToDate(new Date(2020-01-07));
		cyclesList.add(cycle);
		
		 cycleRepository.saveAll(cyclesList);
		 
		
		return null;
	}
	


}
