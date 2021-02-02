package com.app.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICandidateDao;

import com.app.pojos.Candidate;


@Service
@Transactional
public class CandidateServiceImpl implements ICandidateService {


	@Autowired
	private ICandidateDao dao;	
	
	
	@Override
	public List<Candidate> getAllCandidates() {
		// TODO Auto-generated method stub
		System.out.println("Dao Implemenation CLass :: + " + dao.getClass().getName());
		return dao.findAll();
	}
	public Optional<Candidate> getCandidateDetails(String cName) {
		// TODO Auto-generated method stub
		return dao.findByName(cName);
	}
	@Override
	public Candidate addCandidateDetails(Candidate transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}
	
	
}
