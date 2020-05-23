package com.frequency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frequency.entity.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
	
	
	Period findByBusinessYearId(Long id);
	
	

}
