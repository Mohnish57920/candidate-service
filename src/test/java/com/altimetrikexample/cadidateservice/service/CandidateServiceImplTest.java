//package com.altimetrikexample.cadidateservice.service;
//
//import com.altimetrikexample.cadidateservice.entity.Candidate;
//import com.altimetrikexample.cadidateservice.exception.exceptions.LowCreditException;
//import com.altimetrikexample.cadidateservice.model.CandidateDto;
//import com.altimetrikexample.cadidateservice.repo.CandidateRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.ui.ModelMap;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class CandidateServiceImplTest {
//
//    @Mock
//    private CandidateRepository candidateRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    private CandidateServiceImpl candidateService;
//
//    @Test
//    void getCandidateById() {
//        Candidate candidate = new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        Mockito.doReturn(Optional.of(candidate)).when(candidateRepository).findById(1L);
//
//        assertEquals(candidateService.getCandidateById(1L), candidate);
//    }
//
//    @Test
//    void getCandidateById_noCandidateFound() {
//        Mockito.doReturn(Optional.empty()).when(candidateRepository).findById(1L);
//        assertNull(candidateService.getCandidateById(1L));
//    }
//
//    @Test
//    void findAll() {
//        List<Candidate> testCandidates = new ArrayList<Candidate>();
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//        testCandidates.add(new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0));
//
//        Mockito.doReturn(testCandidates).when(candidateRepository).findAll();
//        assertEquals(candidateService.findAll(), testCandidates);
//    }
//
//    @Test
//    void saveCandidate() {
//        CandidateDto candidateDto = new CandidateDto(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        Candidate candidate = new Candidate(1L, "Jack", "jack@gmail.com", 20000, 14000.0);
//        Mockito.when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);
//
//        candidateService.saveCandidate(candidateDto);
//        Mockito.verify(candidateRepository).save(candidate);
//    }
//
//    @Test()
//    void saveCandidate_withLowCredit() {
//        CandidateDto candidateDto = new CandidateDto(1L, "Jack", "jack@gmail.com", 10000, 14000.0);
//        Candidate candidate = new Candidate(1L, "Jack", "jack@gmail.com", 10000, 14000.0);
//        Mockito.when(modelMapper.map(candidateDto, Candidate.class)).thenReturn(candidate);
//
//        assertThrows(LowCreditException.class, () -> candidateService.saveCandidate(candidateDto));
//        Mockito.verifyNoInteractions(candidateRepository);
//    }
//}