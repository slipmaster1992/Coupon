package com.example.demo.DBDAO;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	/**
	 * Updating Customer Set Only Password By ID
	 * 
	 * @param password
	 * @param id
	 */
	@Modifying
	@Transactional
	@Query("UPDATE Customer cust SET cust.password = :password WHERE cust.id = :id")
	void updateCustomer(@Param("password") String password, @Param("id") long id);

	/**
	 * Getting Customer By Name And Password
	 * 
	 * @param custName
	 * @param password
	 * @return Customer
	 */
	Customer findCustomerByCustNameAndPassword(String custName, String password);

	/***
	 * Insert into Customer Coupon
	 * 
	 * @param customerId
	 * @param couponId
	 */
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO customer_coupons (customers_id, coupons_id) VALUES (:customerId, :couponId)", nativeQuery = true)
	void insertCustomerCoupon(@Param("customerId") long customerId, @Param("couponId") long couponId);


	/**
	 * Getting Customer By Name 
	 * 
	 * @param custName
	 * @param password
	 * @return Customer
	 */
	Customer findCustomerByCustName(String custName);






}
