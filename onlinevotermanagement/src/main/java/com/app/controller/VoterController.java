package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Voter;
import com.app.service.IVoterService;

@RestController
@RequestMapping("/voters")
@CrossOrigin(origins = "http://localhost:8080")
public class VoterController {

	//dependancy
	@Autowired
	private IVoterService service;
	public VoterController() {
		
		System.out.println("in ctor of " + getClass().getName());
		
	}
	//Restfull end point
	@GetMapping
	public ResponseEntity<?> listAllVoters()
	{
		System.out.println("In List all Voters :: ");
		List<Voter> voters = service.getAllVoters();
		if (voters.isEmpty())
			// empty product list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return new ResponseEntity<>(voters, HttpStatus.OK);
	}
	
	@GetMapping("/{voterName}")
	public ResponseEntity<?> getvoterDetails(@PathVariable String voterName) {
		System.out.println("in get prod details " + voterName);
		// invoke service method
		Voter voterDetails = service.getVoterDetails(voterName);
		// valid name : HTTP 200 , marshalled product details
		if (voterDetails!=null)
			return new ResponseEntity<>(voterDetails, HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{voterName}")
	 public boolean deleteVoter(@PathVariable String voterName) {
		System.out.println("in get prod details " + voterName);
	    service.delete(voterName);
		return true;
	}
	
	
}
