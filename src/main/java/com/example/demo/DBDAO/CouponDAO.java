package com.example.demo.DBDAO;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.common.CouponType;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponExistException;
import com.example.demo.Exception.CouponNotExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.entities.Coupon;
@Service
public interface CouponDAO {

	void createCoupon(Coupon c , long compId)throws CompanyNotExistException , CouponExistException;

	void removeCoupon(long coupId , long compId)throws CompanyNotExistException , CouponNotExistException;

	void updateCoupon(Date endDate , double price , long coupId , long compId)throws CompanyNotExistException , CouponNotExistException;

	Coupon getCoupon(long coupId)throws CouponNotExistException;

	ArrayList<Coupon>getAllCoupons()throws CouponsNotExistException;

	ArrayList<Coupon>getCouponByType(CouponType couponType)throws CouponNotExistException;

}
