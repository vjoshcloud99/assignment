package com.frequency.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frequency.entity.Cycle;
import com.frequency.entity.Frequency;
import com.frequency.entity.Period;
import com.frequency.repository.CycleRepository;
import com.frequency.repository.FrequencyRepository;
import com.frequency.repository.PeriodRepository;
import com.frequency.service.CycleService;

@Service
@Transactional
public class CycleServiceImpl implements CycleService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CycleRepository cycleRepository;

	@Autowired
	private FrequencyRepository frequencyRepository;

	@Autowired
	private PeriodRepository periodRepository;

	/*	@Override
		public prepareCycleData(Period period, Frequency frequency) {
			
			log.info("inside prepareCycleData impl ");
	
			List<Cycle> cyclesList = new ArrayList<>();
			Cycle cycle = new Cycle();
			cycle.setBusinessYearId(period);
			cycle.setFrequencyId(frequency);
			cycle.setPeriodName("week 1");
			cycle.setFromDate(new Date(2020 - 01 - 06));
			cycle.setToDate(new Date(2020 - 01 - 012));
			cyclesList.add(cycle);
	
			return cycleRepository.saveAll(cyclesList);
	
		}*/

	@Override
	public List<Cycle> findCyclesForFrequency() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareCycleData(Long businessYearId, Long frequencyId) {
		
		Period period=periodRepository.getOne(businessYearId);
		
		Frequency frequency = frequencyRepository.getOne(frequencyId);
		
		
		
	}

}
