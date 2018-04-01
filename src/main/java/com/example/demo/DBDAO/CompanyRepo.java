package com.example.demo.DBDAO;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Company;

@Repository
public interface CompanyRepo  extends CrudRepository<Company, Long>{

	/***
	 * Updating Company query changing only password and email by id
	 * @param password
	 * @param email
	 * @param id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Company comp SET comp.password = :password , comp.email = :email WHERE comp.id =:id")
	public void updateCompany(@Param("password") String password , @Param("email") String email , @Param("id") long id);

	/***
	 * Find Company by id & password for login
	 * @param name
	 * @param password
	 * @return Company
	 */
	Company findCompanyByCompanyNameAndPassword(String name , String password);

	/***
	 * Find Company by its name - for creating new Companies
	 * @param name
	 * @return
	 */
	Company findCompanyByCompanyName(String name);

}
