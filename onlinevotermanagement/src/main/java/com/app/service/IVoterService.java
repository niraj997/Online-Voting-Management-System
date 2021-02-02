package com.app.service;


import java.util.List;
import java.util.Optional;

import com.app.pojos.Voter;

public interface IVoterService {

	 //list all products
	List<Voter> getAllVoters();

	

	Voter getVoterDetails(String vName);
	
	boolean delete(String name);
}
