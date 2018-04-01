package com.example.demo.DBDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.common.CouponType;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponExistException;
import com.example.demo.Exception.CouponNotExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;

import Connections.Connection;
import Connections.ConnectionPool;

@Service
public class CouponDBDAO implements CouponDAO{

	@Autowired
	private CouponRepo coupRepo;

	@Autowired
	private CompanyRepo compRepo;
  
	
	private ConnectionPool cp = ConnectionPool.getInstance();




	/***
	 * Creating new Company's Coupon
	 */
	@Override
	public void createCoupon(Coupon c, long compId) throws CompanyNotExistException, CouponExistException {
		Connection con = cp.getConnection();
		Company	comp = compRepo.findOne(compId);
		c.setCompany(comp);
		coupRepo.save(c);
		cp.returnConnection(con);
	}

	/***
	 * Removing Company's Coupon
	 */
	@Override
	public void removeCoupon(long coupId, long compId) throws CompanyNotExistException, CouponNotExistException {
		Connection con = cp.getConnection();
		coupRepo.removeCoupon(coupId, compId);
		cp.returnConnection(con);
	}

	/***
	 * Updating Coupon only endDate & price
	 */
	@Override
	public void updateCoupon(Date endDate, double price, long coupId, long compId)
			throws CompanyNotExistException, CouponNotExistException {
		Connection con = cp.getConnection();
		coupRepo.updateCoupon(endDate, price, coupId, compId);
		cp.returnConnection(con);
	}


	/**
	 * Updating Coupon Amount By ID
	 * @param coupId
	 */
	public void updateCouponAmount(long coupId) {
		Connection con = cp.getConnection();
		coupRepo.updateCouponAmount(coupId);
		cp.returnConnection(con);
	}




	/***
	 * Getting Coupon by id
	 */
	@Override
	public Coupon getCoupon(long coupId) throws CouponNotExistException {
		
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return coupRepo.findOne(coupId);
		
	}

	/***
	 * Get All Coupons
	 */
	@Override
	public ArrayList<Coupon> getAllCoupons() throws CouponsNotExistException {
		Connection con = cp.getConnection();
		ArrayList<Coupon> allCoupons = (ArrayList<Coupon>) coupRepo.findAll();
		cp.returnConnection(con);
		return allCoupons;

	}

	/***
	 * Get Coupons by type
	 */
	@Override
	public ArrayList<Coupon> getCouponByType(CouponType couponType) throws CouponNotExistException {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return coupRepo.findBytype(couponType);

	}

	/**
	 * Getting Coupon By Title
	 * @param title
	 * @return
	 */
	public Coupon getCouponByTitle(String title) {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return coupRepo.findByTitle(title);

	}

	/**
	 * Getting Customer Coupon By Customer ID And Coupon ID
	 * @param custId
	 * @param coupId
	 * @return
	 */
	public Coupon getCustomerCoupon(long custId, long coupId) {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return coupRepo.findCustomerCoupon(custId, coupId);

	}


	/**
	 * Getting All Customer Coupons 
	 * By Customer ID 
	 * @param custId
	 * @return
	 */
	public List<Coupon> getCustomerCoupons(long custId){
		Connection con = cp.getConnection();
		List<Coupon>custCoupons = coupRepo.findCustomerCoupons(custId);
		cp.returnConnection(con);
		return custCoupons;

	}

	/**
	 * Getting Customer Coupons By Type
	 * And Customer ID
	 * @param custId
	 * @param type
	 * @return
	 */
	public List<Coupon> getCustomerCouponsByType(long custId , CouponType type){
		Connection con = cp.getConnection();
		List<Coupon> custCouponsByType = coupRepo.findCustomerCouponsByType(custId, type);
		cp.returnConnection(con);
		return custCouponsByType;

	}


	/**
	 * Getting Customer Coupons By Price
	 * And Customer ID
	 * @param custId
	 * @param price
	 * @return
	 */
	public List<Coupon> getCustomerCouponsByPrice(long custId , double price){
		Connection con = cp.getConnection();
		List<Coupon> custCouponsByPrice = coupRepo.findCustomerCouponsByPrice(custId, price);
		cp.returnConnection(con);
		return custCouponsByPrice;

	}

	/**
	 * Getting Customer Coupons By Date
	 * And Customer ID
	 * @param custId
	 * @param date
	 * @return
	 */
	public List<Coupon> getCustomerCouponsByDate(long custId , Date date){
		Connection con = cp.getConnection();
		List<Coupon> custCouponsByDate = coupRepo.findCustomerCouponsByDate(custId, date);
		cp.returnConnection(con);
		return custCouponsByDate;

	}



}
