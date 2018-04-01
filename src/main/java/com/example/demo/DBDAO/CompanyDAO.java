package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.CompaniesNotExistException;
import com.example.demo.Exception.CompanyExistException;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;
@Service
public interface CompanyDAO {

	void createCompany(Company c) throws CompanyExistException;

	void removeCompany(long id) throws CompanyNotExistException;

	void updateCompany(String email, String password , long id) throws CompanyNotExistException;

	Company getCompany(long id) throws CompanyNotExistException;

	ArrayList<Company> getAllCompanies() throws CompaniesNotExistException;

	ArrayList<Coupon> getCoupons(long compId) throws CouponsNotExistException , CompanyNotExistException;

	boolean login(String companyName, String password);
}
