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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.IAdminService;
import com.app.service.ICandidateService;


@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:8080")

public class AdminController {
	
	@Autowired
	private IAdminService service;
	public AdminController() {
		
		System.out.println("in ctor of " + getClass().getName());
		
	}
	@PostMapping("authenticate")
	public String authenticateAdmin(@RequestBody String email ,@RequestBody String password) {
		return service.authenticateAdmin(email, password);
	}
  
     
}
