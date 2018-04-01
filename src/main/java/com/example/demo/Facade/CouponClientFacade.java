package com.example.demo.Facade;

import org.springframework.stereotype.Component;

import com.example.common.ClientType;
@Component
public interface CouponClientFacade {
	
	/**
	 * Login Method
	 * @param name
	 * @param password
	 * @param clientType
	 * @return Facade
	 */
	public CouponClientFacade login (String name, String password, ClientType clientType);


     }
