package com.frequency.serviceImpl;

import com.frequency.repository.FrequencyRepository;
import com.frequency.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrequencyServiceImpl implements FrequencyService {

    @Autowired
    private FrequencyRepository frequencyRepository;

}
