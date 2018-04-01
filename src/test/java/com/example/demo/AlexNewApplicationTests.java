package com.example.demo;



import java.util.ArrayList;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.common.ClientType;
import com.example.common.CouponType;
import com.example.demo.Entry.LoginSystem;
import com.example.demo.Exception.CompaniesNotExistException;
import com.example.demo.Exception.CompanyExistException;
import com.example.demo.Exception.CompanyNotExistException;
import com.example.demo.Exception.CouponAmountIsZeroException;
import com.example.demo.Exception.CouponExistException;
import com.example.demo.Exception.CouponNotExistException;
import com.example.demo.Exception.CouponTitleExistException;
import com.example.demo.Exception.CouponsNotExistException;
import com.example.demo.Exception.CustomerAlreadyHaveCouponException;
import com.example.demo.Exception.CustomerExistException;
import com.example.demo.Exception.CustomerNotExistException;
import com.example.demo.Exception.CustomersNotExistException;
import com.example.demo.Exception.NoCouponsAtAllException;
import com.example.demo.Facade.AdminFacade;
import com.example.demo.Facade.CompanyFacade;
import com.example.demo.Facade.CustomerFacade;
import com.example.demo.entities.Company;
import com.example.demo.entities.Coupon;
import com.example.demo.entities.Customer;


import sidekick.DateMaker;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlexNewApplicationTests {

	// Before & After
	@BeforeClass
	public static void beforeEverything()
	{
		System.out.println("########################");
	}

	@AfterClass
	public static void afterEverything()
	{
		System.out.println("########################");
	}






	// Spring members / facades

	@Autowired
	private LoginSystem couponsystem;



	@Test
	public void contextLoads() throws CompanyNotExistException, CouponExistException, NoCouponsAtAllException, CustomerNotExistException, CouponAmountIsZeroException, CouponNotExistException  {




		/**
		 * Login Method For Admin
		 */
		AdminFacade af = (AdminFacade) couponsystem.login("admin", "1234", ClientType.ADMIN);

		System.out.println(af);



		/**
		 * Creating New Company
		 */
		//Company comp1 = new Company("Teva","1111","Teva@gmail.com");
		//Company comp2 = new Company("Apple","2222","Apple@gmail.com");
		//Company comp3 = new Company("Samsung","3333","Samsung@gmail.com");
		//Company comp4 = new Company("Intel","4444","Intel@gmail.com");
		//Company comp5 = new Company("Google","5555","Google@gmail.com");
		//Company comp6 = new Company("Facebook","6666","Facebook@gmail.com");
		//Company comp7 = new Company("Amazon","7777","Amazon@gmail.com");
		Company comp8 = new Company("PayPal","8888","PayPal@gmail.com");
		
        
		try {

			af.createCompany(comp8);
		//	af.createCompany(comp2);
		//	af.createCompany(comp3);
			//af.createCompany(comp4);
			//af.createCompany(comp5);
			//af.createCompany(comp6);
		//	af.createCompany(comp7);

		} catch (CompanyExistException e) {

			System.out.println(e.getMessage());

		}
	/**
	 * Removing Company By ID	 
		 */
	  	try {

			af.removeCompany(7);
		}
	catch (CompanyNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * Updating Company By ID
		 * Setting New Email And Password 
		 */
		try {

			af.updateCompany("4321", "hey@gmail.com", 2);

		}
		catch (CompanyNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * Getting Company By ID
		 */
		try {

			Company company =	af.getCompany(22);

			System.out.println("Company By ID " + company);
		}catch(CompanyNotExistException e) {

		System.out.println(e.getMessage());

		}


		/**
		 * Getting All Companies
		 */
		try {

			ArrayList<Company>compList = af.getAllCompanies();
			System.out.println("List Of All Componies " + compList);

		}catch (CompaniesNotExistException e) {

			System.out.println(e.getMessage());

		}


		


		/**
		 * Creating New Customer
		 */
		
		Customer cust1 = new Customer("Jack","1111");
		//Customer cust2 = new Customer("Amy","2222");
		//Customer cust3 = new Customer("Bill","3333");
	   	//Customer cust4 = new Customer("Debby","4444");
		//Customer cust5 = new Customer("May","5555");
		//Customer cust6 = new Customer("Neta","6666");
		//Customer cust7 = new Customer("Ben","7777");
		
		
		
		try {

			af.createCustomer(cust1);
		//	af.createCustomer(cust2);
			//af.createCustomer(cust3);
			//af.createCustomer(cust4);
			//af.createCustomer(cust5);
			//af.createCustomer(cust6);
		//	af.createCustomer(cust7);

		}catch(CustomerExistException e) {

			System.out.println(e.getMessage());
		}


		/**
		 * Removing Customer By ID
		 */
		try {

			af.removeCustomer(14);

		}catch (CustomerNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * Updating Customer By ID
		 * Setting New Password
		 */
		try {

			af.updateCustomer("666", 12);

		} catch(CustomerNotExistException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * Getting Customer By ID
		 */
		try {

			Customer cust = af.getCustomer(5);
			System.out.println("Customer By ID " + cust);

		} catch(CustomerNotExistException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * 
		 * Getting List Of All Customers
		 */
		try {


			ArrayList<Customer>custList = af.getAllCustomers();
			System.out.println("List Of All Customers " + custList);

	} catch(CustomersNotExistException e) {

			System.out.println(e.getMessage());

		}






		/**
		 * Login Method For Company
		 */
		CompanyFacade compf =  (CompanyFacade) couponsystem.login("Teva", "1111", ClientType.COMPANY);

		System.out.println(compf);
		System.out.println(compf.getLoginCompany());






		/**
		 * Creating New Coupons	
		 */

		//Coupon coup1 = new Coupon("buisness", DateMaker.dateHelper(92, 12, 3), DateMaker.dateHelper(2020, 02, 12), 150, CouponType.CAMPING, "hi",
		//		15, "hi");
		//Coupon coup2 = new Coupon("rolling hash", DateMaker.dateHelper(96, 11, 6), DateMaker.dateHelper(2017, 04, 21), 220, CouponType.ELECTRICY, "hi",
		//		700, "hi");
	    //Coupon coup3 = new Coupon("smashing pappers", DateMaker.dateHelper(99, 10, 22), DateMaker.dateHelper(2009, 06, 14), 340, CouponType.FOOD, "hi",
		//		45, "hi");
		//Coupon coup4 = new Coupon("licking peaches", DateMaker.dateHelper(95,03 , 12), DateMaker.dateHelper(2006, 11, 28), 550, CouponType.RESTURANTS, "hi",
		//		33, "hi");
		//Coupon coup5 = new Coupon("fishing", DateMaker.dateHelper(97, 01, 19), DateMaker.dateHelper(2008, 12, 24), 1000, CouponType.SPORTS, "hi",
		//		80, "hi");
		//Coupon coup6 = new Coupon("Fighting", DateMaker.dateHelper(97, 01, 19), DateMaker.dateHelper(2007, 01, 05), 1000, CouponType.CAMPING, "hi",
		//		80, "hi");
		//Coupon coup7 = new Coupon("JUmping", DateMaker.dateHelper(97, 01, 19), DateMaker.dateHelper(2005, 02, 9), 1000, CouponType.HEALTH, "hi",
		//	80, "hi");

		Coupon coup8 = new Coupon("Swimming", DateMaker.dateHelper(1956, 02, 14), DateMaker.dateHelper(2019, 06,15), 200, CouponType.ELECTRICY, "hi",
				80, "hi");


		try {

			compf.createCoupon(coup8);
			//compf.createCoupon(coup2);
			//compf.createCoupon(coup3);
			//compf.createCoupon(coup4);
			//compf.createCoupon(coup5);
			//compf.createCoupon(coup6);
			//compf.createCoupon(coup7);
		}
		catch (CompanyNotExistException |  CouponTitleExistException e ){
			System.out.println(e.getMessage());
		}

		/**
		 * Removing Coupon By ID And Company ID
		 */
		try {


			compf.removeCoupon(15,1);

		} catch  (CouponNotExistException | CompanyNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * Updating Company Coupon By
		 * Company ID And Coupon ID
		 * Setting Only End Date And Price
		 */
	try {

			compf.updateCoupon( DateMaker.dateHelper(3000,03 , 12), 1500, 17, 1);

		} catch (CompanyNotExistException | CouponNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * 
		 * Getting Coupon By ID
		 * 
		 */
		try {

			Coupon coup = compf.getCoupon(17);
			System.out.println("Coupon By ID " + coup);



		} catch (CouponNotExistException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * Getting List Of Coupons
		 */
		try {

			ArrayList<Coupon> coupList =  compf.getAllCoupons();
			System.out.println("List Of All Coupons " + coupList);
		} catch (CouponsNotExistException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * Getting List Of Coupons By Type
		 */
		try {

			ArrayList<Coupon> typeList = compf.getCouponByType(CouponType.SPORTS);
			System.out.println("List By Type " + typeList);

		} catch (CouponNotExistException e) {

			System.out.println(e.getMessage());

		}


		/**
		 * Login Method For Customer
		 */
		CustomerFacade custf = (CustomerFacade) couponsystem.login("Bill", "3333", ClientType.CUSTOMER);

		System.out.println(custf);
		System.out.println(custf.getLoginCustomer());


		/**
		 * Customer Purchase Coupon
		 * By Coupon ID
		 */
		try {
             
			custf.purchesCoupon(10, 17);
			custf.purchesCoupon(10, 18);
			custf.purchesCoupon(11, 19);
			custf.purchesCoupon(12, 20);
		}catch(CouponNotExistException | CustomerNotExistException | CustomerAlreadyHaveCouponException e) {

		System.out.println(e.getMessage());
		}




		/**
		 * Getting Customer Coupon	
		 * By Customer ID And Coupon ID	
		 */
		Coupon coup = custf.getCustomerCoupon(12, 20);

		System.out.println("Hi I'M The  " +coup);



		/**
		 * Getting All Customer Coupons 
		 * By Customer ID 
		 */
		try {

			ArrayList<Coupon>custCoupons = (ArrayList<Coupon>) custf.getCustomerCoupons(10);
			System.out.println("Purchased Coupons " + custCoupons);
		} catch (CustomerNotExistException | NoCouponsAtAllException e) {

			System.out.println(e.getMessage());
		}


		/**
		 * Getting Customer Coupons By Type
		 * And Customer ID
		 */
		try {

			ArrayList<Coupon> custCouponsByType = (ArrayList<Coupon>) custf.getCustomerCouponsByType(113, CouponType.FOOD);

			System.out.println("By Type " + custCouponsByType);

	}catch (CustomerNotExistException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * Getting Customer Coupons By Price
		 * And Customer ID
		 */
		try {


			ArrayList<Coupon> custCouponsByPrice = (ArrayList<Coupon>) custf.getCustomerCouponsByPrice(113, 80.0);
			System.out.println("By Price " + custCouponsByPrice);
		} catch (CustomerNotExistException | NoCouponsAtAllException e) {

			System.out.println(e.getMessage());

		}

		/**
		 * Getting Customer Coupon By Date
		 * And Customer ID
		 */
		try {

			ArrayList<Coupon> custCouponsByDate = (ArrayList<Coupon>) custf.getCustomerCouponsByDate(12, DateMaker.dateHelper(2007, 02,05));
			System.out.println("By Date " + custCouponsByDate);

	}catch (CustomerNotExistException | NoCouponsAtAllException e) {

			System.out.println(e.getMessage());

		}


	}


}


