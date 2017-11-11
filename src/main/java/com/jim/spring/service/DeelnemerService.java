package com.jim.spring.service;

import com.jim.spring.domain.Deelnemer;
import com.jim.spring.repository.DeelnemerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by jim on 10-11-17.
 */
@Service
public class DeelnemerService {

    private DeelnemerRepository deelnemerRepository;

    public DeelnemerService(DeelnemerRepository deelnemerRepository) {
        this.deelnemerRepository = deelnemerRepository;
    }

    public List<Deelnemer> getAllDeelnemers(){
       return StreamSupport.stream(deelnemerRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Deelnemer findDeelnemerByName(String name){
        return deelnemerRepository.findOneByName(name);
    }
}
