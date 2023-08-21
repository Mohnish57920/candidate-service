package com.altimetrikexample.cadidateservice.repo;

import com.altimetrikexample.cadidateservice.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
