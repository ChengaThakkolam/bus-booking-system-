package com.example.demo.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.UserRegistration;


@Repository
public interface UserRegistrationRepo extends CrudRepository<UserRegistration, String> {
	
	
	@Modifying
	@Query("update UserRegistration u set u.loginStatus=true  where u.mobile=:mobile and u.password=:password")
	public Integer updateLoginStatusUsingMobileAndPWD(@Param("mobile") String mobile,@Param("password") String password); 
	
	
	@Modifying
	@Query("update UserRegistration u set u.loginStatus=false  where u.mobile=:mobile")
	public Integer updateLoginStatusUsingMobile(@Param("mobile") String mobile);
	
	public UserRegistration findByMobileAndPassword(String mobile,String password);
	
	
	public UserRegistration findByMobile(String mobile);

}
