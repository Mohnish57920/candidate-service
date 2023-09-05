//package com.altimetrikexample.cadidateservice.controller;
//
//import com.altimetrikexample.cadidateservice.entity.Candidate;
//import com.altimetrikexample.cadidateservice.model.CandidateDto;
//import com.altimetrikexample.cadidateservice.service.CandidateService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class CandidateControllerTest {
//
//    @Mock
//    private CandidateService candidateService;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private CandidateController candidateController;
//
//    @Test
//    void getCandidateTest() {
//        // setup
//        Candidate testCandidate = new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        CandidateDto testCandidateDto = new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//
//        Mockito.doReturn(testCandidate).when(candidateService).getCandidateById(1L);
//        Mockito.when(modelMapper.map(testCandidate, CandidateDto.class)).thenReturn(testCandidateDto);
//
//        assertEquals(candidateController.getCandidate(1L), ResponseEntity.ok(testCandidateDto));
//    }
//
//    @Test
//    void getCandidateTest_NoCandidateFound() {
//        // setup
//        CandidateDto testCandidateDto = new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//
//        Mockito.doReturn(null).when(candidateService).getCandidateById(1L);
//        assertEquals(candidateController.getCandidate(1L), ResponseEntity.status(HttpStatus.NOT_FOUND).body("No resource found for the given candidate with id : 1"));
//    }
//
//    @Test
//    void getAllCandidates() {
//
//        List<CandidateDto> testCandidatesDtoList = new ArrayList<CandidateDto>();
//        testCandidatesDtoList.add(new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidatesDtoList.add(new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidatesDtoList.add(new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//
//        List<Candidate> testCandidates = new ArrayList<Candidate>();
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//
//        Mockito.doReturn(testCandidates).when(candidateService).findAll();
//        Mockito.doReturn(new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0))
//                .when(modelMapper).map(testCandidates.get(0), CandidateDto.class);
//
//        assertEquals(candidateController.getAllCandidates(), ResponseEntity.ok(testCandidatesDtoList));
//    }
//
//    @Test
//    void addCandidate() {
//        CandidateDto candidateDto =new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        Candidate candidate = new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        Mockito.doReturn(candidate)
//                .when(candidateService).saveCandidate(candidateDto);
//
//        assertEquals(candidateController.addCandidate(candidateDto), ResponseEntity.status(HttpStatus.CREATED).body("Added new candidate"));
//    }
//}