package com.frequency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frequency.entity.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {

	List<Cycle> findByBusinessYearId(Long businessId);
	List<Cycle> findByFrequencyId(Long frequencyId);
	List<Cycle> findByPeriodAndFrequency(Long businessId, Long frequencyId);

}
