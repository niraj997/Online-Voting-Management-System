package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


import com.app.pojos.Gender;

@Entity
@Table(name="Candidates")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="candidate_id")
	private Integer candidate_id;
	@Column(length = 50,unique = true , nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(length=20 , nullable = false )
	private Gender gender;
	@Column(length = 50 , nullable = false)
	private String party;
	@Column(length = 50,unique = true , nullable = false)
	private String email;
	@Column(length = 50,unique = true , nullable = false)
	private String password;
	private Integer votes;
	@Column(name = "dob")
	private LocalDate dob;

	public Candidate() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Candidate(Integer candidate_id, String name, Gender gender, String party, String email, String password,
			 Integer votes, LocalDate dob) {
		super();
		this.candidate_id = candidate_id;
		this.name = name;
		this.gender = gender;
		this.party = party;
		this.email = email;
		this.password = password;
		this.votes = votes;
		this.dob = dob;
	}


	public Integer getCandidate_id() {
		return candidate_id;
	}


	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public  Integer getVotes() {
		return votes;
	}

	public void setVotes( Integer votes) {
		this.votes = votes;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Candidate [candidate_id=" + candidate_id + ", name=" + name + ", gender=" + gender + ", party=" + party
				+ ", email=" + email + ", password=" + password + ", votes=" + votes + ", dob=" + dob + "]";
	}




	
	

}

