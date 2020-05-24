package com.frequency.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

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

	static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private CycleRepository cycleRepository;

	@Autowired
	private FrequencyRepository frequencyRepository;

	@Autowired
	private PeriodRepository periodRepository;

	@Override
	public List<Cycle> findByPeriodAndFrequency(Long businessYearId, Long frequencyId){
		List<Cycle> cyclesList = cycleRepository.findByPeriodAndFrequency(businessYearId, frequencyId);
		return cyclesList;
	}

	@Override
	public List<Cycle> findByBusinessYearId(Long businessYearId){

		List<Cycle> cyclesList = cycleRepository.findByBusinessYearId(businessYearId);
		return cyclesList;
	}

	@Override
	public List<Cycle> findByFrequencyId(Long frequencyId){

		List<Cycle> cyclesList = cycleRepository.findByFrequencyId(frequencyId);
		return cyclesList;
	}

	@Override
	public void prepareCycleData(Long businessYearId, Long frequencyId) {

		Period period = periodRepository.getOne(businessYearId);
		Frequency frequency = frequencyRepository.getOne(frequencyId);

		try {
			String strFromDate = period.getFromDate(); // dd-MMM formatted string need to convert into actual dates based on some logic
			String strEndDate = period.getToDate(); // dd-MMM formatted string need to convert into actual dates based on some logic
			// ToDO Need to change these hard coded dates as per period from and end date
			Date startDate =  sd.parse("2020-04-01");
			Date endDate =  sd.parse("2021-03-31");
			List<Cycle> cycles = prepareCyclesData(startDate, endDate, period, frequency);

			cycleRepository.saveAll(cycles);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}


	public List<Cycle> prepareCyclesData (Date start, Date end, Period period, Frequency frequency) {

		List<Cycle> cycles = new ArrayList<>();
		String periodName;
		switch (frequency.getFrequencyName()){
			case "Daily":
				periodName = "Day";
				break;
			case "Weekly":
				periodName = "Week";
				break;
			case "Bi-Weekly":
				periodName = "Bi-Week";
				break;
			case "Semi-Monthly":
				periodName = "Semi-Month";
				break;
			case "Monthly":
				periodName = "Month";
				break;
			default:
				periodName = "Day";
		}

		Calendar startCalendar = GregorianCalendar.getInstance();
		startCalendar.setTime(start);

		Calendar endCalendar = GregorianCalendar.getInstance();
		endCalendar.setTime(end);

		int count = 1;
		startCalendar.add(Calendar.DAY_OF_MONTH, -1);
		while (startCalendar.before(endCalendar)) {
			Cycle cycle = new Cycle();
			cycle.setPeriodName(periodName + count);
			startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			cycle.setFromDate(startCalendar.getTime());
			cycle.setBusinessYearId(period);
			cycle.setFrequencyId(frequency);
//			System.out.print(periodName + count + ", Start: " + sd.format(startCalendar.getTime()));
			if(frequency.getFrequencyId() == 1){ // Daily
				startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			}
			if(frequency.getFrequencyId() == 2) { // Weekly
				startCalendar.add(Calendar.DAY_OF_MONTH, 7);
			}

			if(frequency.getFrequencyId() == 3) { // Bi-weekly
				startCalendar.add(Calendar.DAY_OF_MONTH, 14);
			}

			if(frequency.getFrequencyId() == 4) { // Semi-Monthly
				startCalendar.add(Calendar.DAY_OF_MONTH, 15);
			}

			if(frequency.getFrequencyId() == 5) { // Monthly
				startCalendar.add(Calendar.MONTH, 1);
			}

			startCalendar.add(Calendar.DAY_OF_MONTH, -1);
//			System.out.println(", End: " + sd.format(startCalendar.getTime()));
			cycle.setToDate(startCalendar.getTime());
			cycles.add(cycle);
			count++;
		}

		return cycles;
	}

}
