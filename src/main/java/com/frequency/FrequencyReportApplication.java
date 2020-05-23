package com.frequency;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.frequency.entity.Cycle;
import com.frequency.entity.Frequency;
import com.frequency.entity.Period;
import com.frequency.repository.FrequencyRepository;
import com.frequency.repository.PeriodRepository;
import com.frequency.service.CycleService;

@SpringBootApplication
public class FrequencyReportApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PeriodRepository periodRepository;
	
	@Autowired
	private FrequencyRepository frequencyRepository;
	
	@Autowired
	private CycleService  cycleService ;

	public static void main(String[] args) {
		SpringApplication.run(FrequencyReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Period period = periodRepository.getOne(3L);
		log.info("id=  " + period.getBusinessYearId() + period.getYearUsedFor());
		
		
		Frequency frequency = frequencyRepository.getOne(1L);
		 log.info("id=  " + frequency.getFrequencyId() + frequency.getFrequencyName());
		 
		 List<Cycle> prepareCycleData = cycleService.prepareCycleData(period, frequency);
		 
		 
		

	}

	/*	@Override
		public void run(String... args) throws Exception {
			SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-mm-dd");
			Date fromDate = objSDF.parse("2020-05-04");
			Date toDate = objSDF.parse("2020-05-10");
	
			List<Frequency> frequencyList = new ArrayList<>();
	
	
			if (fromDate.compareTo(toDate) < 0) {
	
				Period period = new Period();
	
				period.setFromDate(fromDate);
				period.setToDate(toDate);findBybusinessYearId
				period.setPeriodId(111L);
				period.setYearUsedFor("india payroll");
				log.info("after 1");
				
				Frequency frequency=new Frequency(2L,"weekly");
				frequencyList.add(frequency);
				
				period.setFrequencyObj(frequencyList);
				log.info("after 2");
				
				frequency.getPeriod().add(period);
				log.info("after 3");
				
				
				repository.save(period);
				
			}
	
		}*/

}
