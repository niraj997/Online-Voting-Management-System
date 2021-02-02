package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Voter;

public interface IVoterDao extends JpaRepository<Voter, Integer>{

	Voter findByName(String vName);
	
}
