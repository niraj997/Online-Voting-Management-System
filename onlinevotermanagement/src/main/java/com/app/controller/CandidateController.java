package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Candidate;
import com.app.pojos.Voter;
import com.app.service.ICandidateService;




@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "http://localhost:8080")
public class CandidateController {
	
	@Autowired
	private ICandidateService service;
	public CandidateController() {
		
		System.out.println("in ctor of " + getClass().getName());
		
	}
	@GetMapping
	public ResponseEntity<?> listAllCandidates()
	{
		System.out.println("In List all Voters :: ");
		List<Candidate> candidates = service.getAllCandidates();
		if (candidates.isEmpty())
			// empty product list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}
	
	@GetMapping("/{candidateName}")
	public ResponseEntity<?> getcandidateDetails(@PathVariable String candidateName) {
		System.out.println("in get prod details " + candidateName);
		// invoke service method
		Optional<Candidate> candidateDetails = service.getCandidateDetails(candidateName);
		// valid name : HTTP 200 , marshalled product details
		if (candidateDetails.isPresent())
			return new ResponseEntity<>(candidateDetails.get(), HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	//request handler method to create a new Candidate
	@PostMapping
	public ResponseEntity<?> addCandidate(@RequestBody Candidate c) {
		System.out.println("in add candidate " + c);
		try {
			Candidate savedCandidate = service.addCandidateDetails(c);
			return new ResponseEntity<>(savedCandidate, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
