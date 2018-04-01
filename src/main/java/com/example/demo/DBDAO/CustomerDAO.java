package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.Exception.CustomerExistException;
import com.example.demo.Exception.CustomerNotExistException;
import com.example.demo.Exception.CustomersNotExistException;
import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;

@Service
public interface CustomerDAO {

	void createCustomer(Customer c) throws CustomerExistException;

	void removeCustomer(long id)throws CustomerNotExistException;

	void updateCustomer(String password , long id)throws CustomerNotExistException;

	Customer getCustomer(long id)throws CustomerNotExistException;

	ArrayList<Customer> getAllCustomers()throws CustomersNotExistException;

	ArrayList<Coupon> getCoupons(long custId)throws CustomerNotExistException , CouponsNotExistException;

	boolean login(String custName, String password);
}
