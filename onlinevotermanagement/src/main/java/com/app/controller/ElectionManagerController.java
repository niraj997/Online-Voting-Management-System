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
import com.app.pojos.ElectionManager;

import com.app.service.ICandidateService;
import com.app.service.IElectionManagerService;


@RestController
@RequestMapping("/electionmanager")
@CrossOrigin(origins = "http://localhost:8080")
public class ElectionManagerController {
	
	@Autowired
	private IElectionManagerService service;
	public ElectionManagerController() {
		
		System.out.println("in ctor of " + getClass().getName());
		
	}
	
	@PostMapping
	public ResponseEntity<?> addElectionManager(@RequestBody ElectionManager m) {
		System.out.println("in add Election Manager " + m);
		try {
			ElectionManager savedElectionManager  = service.addElectionManagerDetails(m);
			return new ResponseEntity<>( savedElectionManager, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
}
