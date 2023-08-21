package com.altimetrikexample.cadidateservice.service;

import com.altimetrikexample.cadidateservice.entity.Candidate;
import com.altimetrikexample.cadidateservice.exception.exceptions.LowCreditException;
import com.altimetrikexample.cadidateservice.model.CandidateDto;
import com.altimetrikexample.cadidateservice.repo.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;

    public CandidateServiceImpl(CandidateRepository candidateRepository, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Function to return
     * @param Id
     * @return
     */
    public Candidate getCandidateById(Long Id){

        Optional<Candidate> candidate = candidateRepository.findById(Id);
        return candidate.orElse(null);
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate saveCandidate(CandidateDto candidateDto) {
        Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
        checkCredit(candidate);
        return candidateRepository.save(candidate);
    }

    private void checkCredit(Candidate candidate) {
        if (candidate.getSalary() - candidate.getExpense() < 1000){
            log.error("Candidate: {}, cannot be persisted since it does not meet minimum credit requirement.", candidate.getName());
            throw new LowCreditException("Credit for the candidate must be more than 1000. ");
        }
    }

}
