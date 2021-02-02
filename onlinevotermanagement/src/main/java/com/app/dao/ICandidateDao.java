package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Candidate;



public interface ICandidateDao extends JpaRepository<Candidate, Integer>{

	Optional<Candidate> findByName(String cName);

	

}
