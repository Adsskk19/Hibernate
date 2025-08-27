package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private int passportNumber;
	
	private String issuesPlace;
	
	//It brings details from User
	@OneToOne(mappedBy = "passport" )
	private User user;
	
	public Passport() {
		
	}

	public Passport(int passportNumber, String issuesPlace) {
		super();
		this.passportNumber = passportNumber;
		this.issuesPlace = issuesPlace;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIssuesPlace() {
		return issuesPlace;
	}

	public void setIssuesPlace(String issuesPlace) {
		this.issuesPlace = issuesPlace;
	}

	public Passport(int passportNumber, String issuesPlace, User user) {
		super();
		this.passportNumber = passportNumber;
		this.issuesPlace = issuesPlace;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", issuesPlace=" + issuesPlace + "]";
	}


	

}
