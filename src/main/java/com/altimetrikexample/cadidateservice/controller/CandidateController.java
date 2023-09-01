package com.altimetrikexample.cadidateservice.controller;

import com.altimetrikexample.cadidateservice.entity.Candidate;
import com.altimetrikexample.cadidateservice.model.CandidateDto;
import com.altimetrikexample.cadidateservice.service.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/candidate")
@Slf4j
public class CandidateController {

    private final CandidateService candidateService;
    private final ModelMapper modelMapper;

    public CandidateController(CandidateService candidateService, ModelMapper modelMapper) {
        this.candidateService = candidateService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    ResponseEntity getCandidate(@PathVariable Long id){
        Candidate candidate = candidateService.getCandidateById(id);
        if(null==candidate){
            log.warn("Could not find candidate with Id : {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No resource found for the given candidate with id : " + id);
        }
        CandidateDto candidateDto = modelMapper.map(candidate, CandidateDto.class);
        log.info("Response sent for candidate with Id : {} & name : {}", id, candidateDto.getName());
        return ResponseEntity.ok(candidateDto);
    }

    @GetMapping
    ResponseEntity<List<CandidateDto>> getAllCandidates(){
        List<Candidate> candidates = candidateService.findAll();
        List<CandidateDto> candidateDtoList = candidates.stream()
                .map(c -> modelMapper.map(c, CandidateDto.class))
                .collect(Collectors.toList());
        log.info("Response sent for {} candidates ", candidateDtoList.size());
        return ResponseEntity.ok(candidateDtoList);
    }

    @PostMapping("/add")
    ResponseEntity addCandidate(@Valid @RequestBody CandidateDto candidateDto){
        candidateService.saveCandidate(candidateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Added new candidate");
    }
}
