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
import javax.persistence.ManyToMany;


@Entity(name = "Customer")
public class Customer {

	// Object members
	@Id
	@Column
	@GeneratedValue
	private long id;



	@Column 
	private String custName;

	@Column 
	private String password;



	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Coupon> coupons = new ArrayList<>();




	//--------CTR------//
	public Customer(String custName, String password) {
		super();
		this.custName = custName;
		this.password = password;
	}


	//-------Empty CTR-----//
	public Customer() {



	}


	//-------Getters And Setters----//
	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public String getCustName() {
		return custName;
	}





	public void setCustName(String custName) {
		this.custName = custName;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}




	//-------ToString-------//
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + "]";
	}


}
