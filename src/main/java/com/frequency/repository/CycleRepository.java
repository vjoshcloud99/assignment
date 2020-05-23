package com.frequency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frequency.entity.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Long> {
	
	

}
