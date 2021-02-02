package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Candidate;


public interface ICandidateService {

	List<Candidate> getAllCandidates();

	Optional<Candidate> getCandidateDetails(String candidateName);

	Candidate addCandidateDetails(Candidate transientPOJO);

	
	
}
