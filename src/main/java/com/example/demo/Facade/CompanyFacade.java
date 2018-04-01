package com.example.demo.Facade;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.ClientType;
import com.example.common.CouponType;
import com.example.demo.DBDAO.CompanyDBDAO;
import com.example.demo.DBDAO.CouponDBDAO;
import com.example.demo.DBDAO.CustomerDBDAO;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponExistException;
import com.example.demo.Exception.CouponNotExistException;
import com.example.demo.Exception.CouponTitleExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;


@Component
public class CompanyFacade implements CouponClientFacade {


	//-------Empty CTR----//
	public CompanyFacade() {

	}



	// Object's members
	private Company loginCompany;


	// DBDAO
	@Autowired
	private CompanyDBDAO compdb;

	@Autowired
	private CouponDBDAO coupdb;



	/***
	 * Login Method for Company Facade
	 */
	@Override
	public CompanyFacade login(String name, String password, ClientType clientType) {
		// Checking type
		if(!clientType.equals(ClientType.COMPANY))
		{
			return null;
		}

		// Checking name & pass
		if(!compdb.login(name, password))
		{
			return null;
		}

		loginCompany = compdb.getCompanyByNameAndPassword(name, password);
		return this;
	}



	/**
	 * Creating New Coupon
	 * @param c
	 * @param compId
	 * @throws CouponTitleExistException
	 * @throws CompanyNotExistException
	 * @throws CouponExistException
	 */
	public void createCoupon(Coupon c) throws CouponTitleExistException, CompanyNotExistException, CouponExistException {

		Coupon coupCheck = coupdb.getCouponByTitle(c.getTitle());

		//    Checking if Coupon Already Exist By Title
		if(coupCheck != null) {

			throw new CouponTitleExistException("This Coupon Is Already Exist");
		}else {

			c.setCompany(loginCompany);
			coupdb.createCoupon(c, loginCompany.getId());

		}	
	}


	/**
	 * Removing Coupon By Coupon ID And Company ID
	 * @param coupId
	 * @param compId
	 * @throws CouponNotExistException
	 * @throws CompanyNotExistException
	 */
	public void removeCoupon(long coupId,long compId) throws CouponNotExistException, CompanyNotExistException {

		Coupon coup = coupdb.getCoupon(coupId);
		Company comp = compdb.getCompany(compId);


		// Checking If Company Or Coupon Are Excisting By ID 

		if(coup == null) {

			throw new CouponNotExistException("Coupon With The ID " + coupId + " Is Not Exist ");

		} if(comp == null) {

			throw new CompanyNotExistException("Company With The ID " + compId + " Is Not Exist");

		} else {

			coupdb.removeCoupon(coupId, compId);


		}

	}

	/**
	 * Updating Company Coupon 
	 * By Company ID And Coupon ID
	 * Setting Only New End Date And Price
	 * @param endDate
	 * @param price
	 * @param coupId
	 * @param compId
	 * @throws CouponNotExistException
	 * @throws CompanyNotExistException
	 */
	public void updateCoupon(Date endDate, double price, long coupId, long compId) throws CouponNotExistException, CompanyNotExistException {

		Coupon coup = coupdb.getCoupon(coupId);
		Company comp = compdb.getCompany(compId);

		if(comp == null) {

			throw new CompanyNotExistException("Company With The ID " + compId + " Is Not Exist ");


		} if (coup == null) {

			throw new CouponNotExistException("Coupon With The ID "+ coupId + " Is Not Exist");

		}else {

			coupdb.updateCoupon(endDate, price, coupId, compId);

		}
	}



	/**
	 * Getting Coupon By ID
	 * @param coupId
	 * @return
	 * @throws CouponNotExistException
	 */
	public Coupon getCoupon (long coupId) throws CouponNotExistException {

		// Checking If Coupon Is Exist
		Coupon coup = coupdb.getCoupon(coupId);

		if(coup == null) {

			throw new CouponNotExistException("Coupon With The  ID " + coupId + " Is Not Exist"); 

		}else {

			return coupdb.getCoupon(coupId);

		}

	}

	/**
	 * Getting List Of All Coupons
	 * @return coupList
	 * @throws CouponsNotExistException 
	 */
	public ArrayList<Coupon> getAllCoupons() throws CouponsNotExistException {

		ArrayList<Coupon>coupList = coupdb.getAllCoupons();

		// Checking If Coupons Are Exist  

		if(coupList == null) {

			throw new CouponsNotExistException("There Are No Coupons !");

		}
		return coupList;

	}


	/**
	 * Getting List Of Coupons By Type
	 * @param couponType
	 * @return
	 * @throws CouponNotExistException
	 */
	public ArrayList<Coupon> getCouponByType(CouponType couponType) throws CouponNotExistException {


		return coupdb.getCouponByType(couponType);

	}



	/***
	 * Getter login Company
	 * @return
	 */
	public Company getLoginCompany() {
		return loginCompany;
	}

	@Override
	public String toString() {
		return "CompanyFacade [loginCompany=" + loginCompany + "]";
	}






}
