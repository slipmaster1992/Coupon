package com.example.demo.DBDAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CompaniesNotExistException;
import com.example.demo.Exception.CompanyExistException;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;

import Connections.Connection;
import Connections.ConnectionPool;

@Service
public class CompanyDBDAO implements CompanyDAO{

	@Autowired
	private CompanyRepo compRepo;

	@Autowired
	private CouponRepo coupRepo;


    private ConnectionPool cp = ConnectionPool.getInstance();




	/***
	 * Creating Company
	 */
	@Override
	
	public void createCompany(Company c) throws CompanyExistException {
		Connection con = cp.getConnection();
		compRepo.save(c);
		cp.returnConnection(con);
	}   

	/***
	 * Remove Company by id
	 */
	@Override
	public void removeCompany(long id) throws CompanyNotExistException {
		Connection con = cp.getConnection();
		compRepo.delete(id);
		cp.returnConnection(con);
	}

	/***
	 * Updating Company set only password & email by id
	 */
	@Override
	public void updateCompany(String email, String password, long id) throws CompanyNotExistException {
		Connection con = cp.getConnection();
		compRepo.updateCompany(password, email, id);
		cp.returnConnection(con);
	}

	/***
	 * Get Company by id
	 */
	@Override
	public Company getCompany(long id) throws CompanyNotExistException {
		
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return compRepo.findOne(id);
		
	}

	/***
	 * Get All Companies
	 */
	@Override
	public ArrayList<Company> getAllCompanies() throws CompaniesNotExistException {
		Connection con = cp.getConnection();
		ArrayList<Company> allCompanies =  (ArrayList<Company>) compRepo.findAll();
		cp.returnConnection(con);
		return allCompanies;

	}

	/***
	 * Get Coupons by Company ID
	 */
	@Override
	public ArrayList<Coupon> getCoupons(long compId) throws CouponsNotExistException, CompanyNotExistException {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return coupRepo.findByCompanyId(compId);

	}

	/***
	 * Login method check if name and password exist on data base
	 */
	@Override
	public boolean login(String companyName, String password) {
		Connection con = cp.getConnection();
		Company check = compRepo.findCompanyByCompanyNameAndPassword(companyName, password);
		cp.returnConnection(con);
		
		if(check == null)
		{
			return false;
		}

		return true;
		
	}

	/***
	 * Get Company by name - for creating new Companies
	 * @param name
	 * @return Company
	 */
	public Company getCompanyByName(String name) {
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return compRepo.findCompanyByCompanyName(name);
		
		
	}

	/***
	 * Return Company by name and password
	 * @param compName
	 * @param password
	 * @return Company
	 */
	public Company getCompanyByNameAndPassword(String compName , String password)
	{
		Connection con = cp.getConnection();
		cp.returnConnection(con);
		return compRepo.findCompanyByCompanyNameAndPassword(compName, password);
		
	}
	

	/***
	 * Removing all Company Coupons
	 * @param companyId
	 */
	public void removeAllCompanyCoupons(long companyId)
	{
		Connection con = cp.getConnection();
		coupRepo.removeAllCompanyCoupons(companyId);
		cp.returnConnection(con);
	}

}
