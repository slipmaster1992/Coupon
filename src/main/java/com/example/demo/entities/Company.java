package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name = "Company")
public class Company {




	//------Object Members----//
	@Id 
	@Column
	@GeneratedValue
	private long id;




	@Column
	private String companyName;

	@Column
	private String password;

	@Column
	private String email;




	@OneToMany(mappedBy = "company" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Coupon> coupons = new ArrayList<>();




	//-------CTR-------//
	public Company(String companyName, String password, String email) {
		super();
		this.companyName = companyName;
		this.password = password;
		this.email = email;
	}


	// ---Empty CTR ----//
	public Company() {


	}




	//------Getters And Setters-----//
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	////// -----   ToString ---------//////
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", password=" + password + ", email=" + email
				+ "]";
	}


}

