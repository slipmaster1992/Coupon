package com.example.demo.Facade;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.ClientType;
import com.example.common.CouponType;
import com.example.demo.DBDAO.CompanyDBDAO;
import com.example.demo.DBDAO.CouponDBDAO;
import com.example.demo.DBDAO.CustomerDBDAO;
import com.example.demo.Exception.CouponAmountIsZeroException;
import com.example.demo.Exception.CouponNotExistException;

import com.example.demo.Exception.CustomerAlreadyHaveCouponException;
import com.example.demo.Exception.CustomerNotExistException;
import com.example.demo.Exception.NoCouponsAtAllException;

import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;

@Component
public class CustomerFacade implements CouponClientFacade {







	//-------Empty CTR-------//

	public CustomerFacade() {

	}


	// Object's members
	private Customer loginCustomer;


	// DBDAO
	@Autowired
	private CompanyDBDAO compdb;

	@Autowired
	private CouponDBDAO coupdb;

	@Autowired
	private CustomerDBDAO custdb;



	@Override
	public CustomerFacade login(String name, String password, ClientType clientType) {
		// Checking type
		if(!clientType.equals(ClientType.CUSTOMER))
		{
			return null;
		}

		// Checking name & pass
		if(!custdb.login(name, password))
		{
			return null;
		}

		loginCustomer = custdb.getCustomerByNameAndPassword(name, password);
		return this;



	}

	/**
	 * Customer Purchase Coupon By Coupon ID
	 * @param custId
	 * @param coupId
	 * @throws CustomerNotExistException
	 * @throws CouponNotExistException
	 * @throws CustomerAlreadyHaveCouponException
	 * @throws CouponAmountIsZeroException 
	 */
	public void purchesCoupon(long custId, long coupId ) throws CustomerNotExistException, CouponNotExistException, CustomerAlreadyHaveCouponException, CouponAmountIsZeroException {

		// Checking If Customer Exist
		Customer cust = custdb.getCustomer(custId);

		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");

		}

		// Checking If Coupon Exist
		Coupon coup = coupdb.getCoupon(coupId);

		if(coup == null) {

			throw new CouponNotExistException("Coupon With The ID " + coupId + " Is Not Exist");	

		}

		// Checking If Customer Already Got The Coupon
		Coupon custCoup = coupdb.getCustomerCoupon(custId, coupId);

		if(custCoup != null) {

			throw new CustomerAlreadyHaveCouponException();
		}

		


		


		// Purchase Coupon
		custdb.purchaseCoupon(custId, coupId);
		coupdb.updateCouponAmount(coupId);
	}


	/**
	 * Getting Customer Purchase Coupon
	 * By Customer ID And Coupon ID
	 * @param custId
	 * @param coupId
	 * @return
	 * @throws NoCouponsAtAllException 
	 * @throws CustomerNotExistException 
	 */
	public Coupon getCustomerCoupon(long custId, long coupId) throws NoCouponsAtAllException, CustomerNotExistException{


		Coupon coup = coupdb.getCustomerCoupon(custId, coupId);
		Customer cust = custdb.getCustomer(custId);
		// Checking If Customer Exist
		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");
		}

		// Checking If Coupon Exist
		if(coup == null) {

			throw new NoCouponsAtAllException("You Have No Purchased Coupon");

		}

		return coup;

	}


	/**
	 * Getting List Of Customer Purchase Coupons
	 * By Customer ID
	 * @param custId
	 * @return
	 * @throws NoCouponsAtAllException
	 * @throws CustomerNotExistException 
	 */
	public List<Coupon> getCustomerCoupons(long custId) throws NoCouponsAtAllException, CustomerNotExistException{


		Customer cust = custdb.getCustomer(custId);
		List<Coupon>custCoupons = coupdb.getCustomerCoupons(custId);


		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");
		}


		if(custCoupons.isEmpty() | custCoupons == null) {

			throw new NoCouponsAtAllException();

		} 

		else {

			return custCoupons;
		}



	}


	/**
	 * Getting Customer Coupons By Type
	 * And Customer ID 
	 * @param custId
	 * @param type
	 * @return
	 * @throws CustomerNotExistException
	 * @throws NoCouponsAtAllException
	 */
	public List<Coupon> getCustomerCouponsByType(long custId,CouponType type) throws CustomerNotExistException, NoCouponsAtAllException{

		Customer cust = custdb.getCustomer(custId);
		List<Coupon>custCoupons = coupdb.getCustomerCouponsByType(custId, type);


		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");
		}


		if(custCoupons.isEmpty() | custCoupons == null) {

			throw new NoCouponsAtAllException();

		} 

		else {

			return custCoupons;
		}


	}


	/**
	 * Getting Customer Coupons By Price
	 * And Customer ID 
	 * @param custId
	 * @param price
	 * @return
	 * @throws CustomerNotExistException
	 * @throws NoCouponsAtAllException
	 */
	public List<Coupon> getCustomerCouponsByPrice(long custId, double price) throws CustomerNotExistException, NoCouponsAtAllException{

		Customer cust = custdb.getCustomer(custId);
		List<Coupon>custCouponsByPrice = coupdb.getCustomerCouponsByPrice(custId, price);


		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");
		}


		if(custCouponsByPrice.isEmpty() | custCouponsByPrice == null) {

			throw new NoCouponsAtAllException();

		} 

		else {

			return custCouponsByPrice;
		}


	}

	/**
	 * Getting Customer Coupons By Date
	 * And Customer ID 
	 * @param custId
	 * @param date
	 * @return
	 * @throws CustomerNotExistException
	 * @throws NoCouponsAtAllException
	 */
	public List<Coupon> getCustomerCouponsByDate(long custId,Date date) throws CustomerNotExistException, NoCouponsAtAllException{

		Customer cust = custdb.getCustomer(custId);
		List<Coupon>custCouponsByDate = coupdb.getCustomerCouponsByDate(custId, date);


		if(cust == null) {

			throw new CustomerNotExistException("Customer With The ID " + custId + " Is Not Exist");
		}


		if(custCouponsByDate.isEmpty() | custCouponsByDate == null) {

			throw new NoCouponsAtAllException();

		} 

		else {

			return custCouponsByDate;
		}


	}




	/***
	 * Getter login Customer
	 * @return
	 */
	public Customer getLoginCustomer() {
		return loginCustomer;
	}

	@Override
	public String toString() {
		return "CustomerFacade [loginCustomer=" + loginCustomer + "]";
	}

















}
