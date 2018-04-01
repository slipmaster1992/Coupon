package com.example.demo.Entry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.common.ClientType;
import com.example.demo.Facade.AdminFacade;
import com.example.demo.Facade.CompanyFacade;
import com.example.demo.Facade.CouponClientFacade;
import com.example.demo.Facade.CustomerFacade;
import com.example.demo.entities.Coupon;

import Connections.ConnectionPool;
import Connections.DailyService;





@Component
@Scope("singleton")

public class LoginSystem {

	@Autowired
	AdminFacade adminFacade;
	@Autowired
	private CompanyFacade compf;

	@Autowired
	private CustomerFacade custf;

    
	//private Thread thread;
	
	//private boolean running = false;
	
//	@Autowired
	//private DailyService ds;
	
	
	
	
	
	/***
	 * Private CTR
	 */
	public LoginSystem() {
		
	}
	
	
	
	
	
	
	/**
	 * Login Method Checking Type At First
	 *
	 * @param name
	 * @param password
	 * @param clientType
	 * @return
	 */
	public CouponClientFacade login(String name, String password, ClientType clientType)
	{
		switch (clientType)
		{
		case ADMIN:
			AdminFacade result =  (AdminFacade) adminFacade.login(name, password,clientType);
			return result;
		case COMPANY:
			CompanyFacade compResult = (CompanyFacade) compf.login(name, password, clientType);
			return compResult;
		case CUSTOMER: 
			CustomerFacade custResult = (CustomerFacade)custf.login(name, password, clientType);				
			return custResult;

		}
		return null;
	}

	/***
	 * Stopping the daily Thread
	 * 
	 */
	//public synchronized void shutdown() 
	//{
		//if(!running) return;
	//	running = false;
	//}
	
	///***
	 //* Starting the daily Thread
	// */
	//public synchronized void start() {
	//	if(running) return;
		//running = true;
		
		// thread = new Thread(new Runnable() {
			
			//@Override
			//public void run() {
			//	while(running){
					
				//	List<Coupon> expireds = ds.getExpired();
					//ds.removeExpired(expireds);
					
				//	try {
					//	Thread.sleep(86400000);
					//} catch (InterruptedException e) {
					//	e.printStackTrace();
					//}
			//	}
		//	}
		//});
		
		//thread.start();
	//}


}
