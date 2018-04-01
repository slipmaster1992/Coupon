package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.Exception.CustomerExistException;
import com.example.demo.Exception.CustomerNotExistException;
import com.example.demo.Exception.CustomersNotExistException;
import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;

import Connections.Connection;
import Connections.ConnectionPool;

@Service
public class CustomerDBDAO implements CustomerDAO {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponRepo couponRepo;

	
	private ConnectionPool cp = ConnectionPool.getInstance();

	/**
	 * Creating Customer
	 */
	@Override
	public void createCustomer(Customer c) throws CustomerExistException {
		Connection con = cp.getConnection();
		customerRepo.save(c);
		cp.returnConnection(con);
	}

	/**
	 * Remove Customer By ID
	 */
	@Override
	public void removeCustomer(long id) throws CustomerNotExistException {
		Connection con = cp.getConnection();
		customerRepo.delete(id);
		cp.returnConnection(con);
	}

	/**
	 * Updating Customer Password By ID
	 */
	@Override
	public void updateCustomer(String password, long id) throws CustomerNotExistException {
		Connection con = cp.getConnection();
		customerRepo.updateCustomer(password, id);
		cp.returnConnection(con);
	}

	/**
	 * Getting Customer By Name
	 * @param customerName
	 * @return Customer
	 */
	public Customer getCustomerByName(String customerName){
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return customerRepo.findCustomerByCustName(customerName);
	}




	/**
	 * Get Customer By ID
	 */
	@Override
	public Customer getCustomer(long id) throws CustomerNotExistException {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return customerRepo.findOne(id);
	}

	/**
	 * Get All Customers
	 */
	@Override
	public ArrayList<Customer> getAllCustomers() throws CustomersNotExistException {
		Connection con = cp.getConnection();
		ArrayList<Customer> allCustomers = (ArrayList<Customer>) customerRepo.findAll();
		cp.returnConnection(con);
		return allCustomers;
	}

	/***
	 * Get All Customer's Coupons by ID
	 */
	@Override
	public ArrayList<Coupon> getCoupons(long custId) throws CustomerNotExistException, CouponsNotExistException {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return couponRepo.findByCustomersId(custId);
	}

	/**
	 * Login Method For Customer
	 */
	@Override
	public boolean login(String custName, String password) {
		Connection con = cp.getConnection();
		Customer check = customerRepo.findCustomerByCustNameAndPassword(custName, password);
		cp.returnConnection(con);
		if(check == null){
			return false;
		}
		return true;
	}

	/***
	 * Getting Customer by name and password
	 * @param custName
	 * @param password
	 * @return Customer
	 */
	public Customer getCustomerByNameAndPassword(String custName , String password)
	{
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return customerRepo.findCustomerByCustNameAndPassword(custName, password);
	}

	/***
	 * Purchasing new Coupon by IDs
	 * @param customerId
	 * @param couponId
	 * @throws CustomerNotExistException
	 * @throws CouponsNotExistException
	 */
	public void purchaseCoupon(long customerId ,  long couponId)throws CustomerNotExistException 
	{
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		customerRepo.insertCustomerCoupon(customerId, couponId);
	}

}
