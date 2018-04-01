package com.example.demo.DBDAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.common.CouponType;
import com.example.demo.entities.Coupon;

@Repository
public interface CouponRepo extends CrudRepository<Coupon, Long> {


	/***
	 * Removing Company Coupon
	 * @param couponId
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon coup WHERE coup.id = :couponId AND coup.company.id = :companyId")
	void removeCoupon(@Param("couponId") long couponId, @Param("companyId") long companyId);

	/***
	 * Removing All Company Coupons
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon coup WHERE coup.company.id = :companyId")
	void removeAllCompanyCoupons(@Param("companyId") long companyId);


	/***
	 * Updating Coupon Amount
	 * @param couponId
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Coupon coup SET coup.amount = coup.amount-1 WHERE coup.id = :couponId")
	void updateCouponAmount(@Param("couponId") long couponId);

	/***
	 * Updating Coupon 
	 * @param couponId
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Coupon coup SET coup.endDate = :endDate, coup.price = :price WHERE coup.id = :couponId AND coup.company.id = :companyId")
	void updateCoupon(@Param("endDate") Date date , @Param("price") double price, @Param("couponId") long couponId , @Param("companyId") long companyId);




	/***
	 * Removing Coupon
	 * @param couponId
	 * @param companyId
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon t WHERE t.id = :couponId")
	void removeCoupon(@Param("couponId") long couponId);



     /**
	 * Get Coupon By Title
	 * @param title
	 * @return
	 */
	Coupon findByTitle(String title);


	/***
	 * Get Coupons by type
	 * @param type
	 * @return Array List
	 */
	ArrayList<Coupon> findBytype(CouponType type);

	/***
	 * Get Coupons by Company id
	 * @param compId
	 * @return Array List
	 */
	ArrayList<Coupon> findByCompanyId(long compId);

	/***
	 * Get Coupons Customer id
	 * @param custId
	 * @return Array List
	 */
	ArrayList<Coupon> findByCustomersId(long custId);



	/***
	 * Find Customer Coupon
	 * By Customer ID And Coupon ID
	 * @param customerId
	 * @param couponId
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.id = :couponId AND coup.id IN (SELECT coup.id FROM coup.customers c WHERE c.id = :customerId)") 
	Coupon findCustomerCoupon(@Param("customerId") long customerId, @Param("couponId") long couponId);



	/***
	 * Find All Customer Coupons
	 * By Customer ID
	 * @param customerId
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.id IN (SELECT coup.id FROM coup.customers c WHERE c.id = :customerId)") 
	List<Coupon> findCustomerCoupons(@Param("customerId") long customerId); 



	/***
	 * Find Customer Coupons by type
	 * @param customerId
	 * @param type
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.type = :type AND coup.id IN (SELECT coup.id FROM coup.customers c WHERE c.id = :customerId)") 
	List<Coupon> findCustomerCouponsByType(@Param("customerId") long customerId, @Param("type") CouponType type);



	/***
	 * Find Customer Coupons by price
	 * @param customerId
	 * @param price
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.price = :price AND coup.id IN (SELECT coup.id FROM coup.customers c WHERE c.id = :customerId)") 
	List<Coupon> findCustomerCouponsByPrice(@Param("customerId") long customerId, @Param("price") double price);

	/***
	 * Find Customer Coupons by date
	 * @param customerId
	 * @param date
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.endDate < :date AND coup.id IN (SELECT coup.id FROM coup.customers c WHERE c.id = :customerId)") 
	List<Coupon> findCustomerCouponsByDate(@Param("customerId") long customerId, @Param("date")Date date);

	/***
	 * Find Expired Coupons
	 * @param expiredDate
	 * @return
	 */
	@Query("SELECT coup FROM Coupon coup WHERE coup.endDate < :expiredDate")
	List<Coupon> findExpiredCoupons(@Param("expiredDate")Date expiredDate);



}

