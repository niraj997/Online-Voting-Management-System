package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVoterDao;
import com.app.pojos.Voter;
@Service
@Transactional
public class VoterServiceImpl implements IVoterService {

	@Autowired
	private IVoterDao dao;	
	
	@Override
	public List<Voter> getAllVoters() {
		// TODO Auto-generated method stub
		System.out.println("Dao Implemenation CLass :: + " + dao.getClass().getName());
		return dao.findAll();
	}
	@Override
	public Voter getVoterDetails(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}
	@Override
	public boolean delete(String name) {
		Voter v= dao.findByName(name);
		dao.delete(v);
		return true;
		
	}
	
	
	
	
	
}
