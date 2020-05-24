package com.frequency.serviceImpl;

import com.frequency.repository.PeriodRepository;
import com.frequency.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;


}
