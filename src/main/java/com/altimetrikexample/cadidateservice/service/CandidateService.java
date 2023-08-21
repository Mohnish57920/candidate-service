package com.altimetrikexample.cadidateservice.service;

import com.altimetrikexample.cadidateservice.entity.Candidate;
import com.altimetrikexample.cadidateservice.model.CandidateDto;

import java.util.List;

public interface CandidateService {

    Candidate getCandidateById(Long Id);
    List<Candidate> findAll();
    Candidate saveCandidate(CandidateDto candidateDto);
}
