package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

//Repository class which extends JpaRepository
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//Query and method for getting users list by firstName
	@Query(value="select * from user_table2 where first_name=?1",nativeQuery =true)
	public List<User> getListByfirstName(String firstName);
   
	//Query and method for getting users list by lastName
	@Query(value="select * from user_table2 where last_name=?1",nativeQuery =true)
	public List<User> getListBylastName(String lastName);
	
	//Query and method for getting users list by pincode
	@Query(value="select * from user_table2 where pincode=?1",nativeQuery =true)
	public List<User> getListbyPincode(int pincode);
	
	//Query and method for updating user by user id
	@Transactional
	@Modifying(clearAutomatically = true)
	  @Query(value = "UPDATE User_table2  set first_name=:first_name,last_name=:last_name,"
	  		+ "city=:city,pincode=:pincode,number=:number,"
	  		+ "date_of_birth=:date_of_birth,joining_date=:joining_date where user_id=:user_id",
	            nativeQuery = true)
	public void updateUser_table2(@Param(value="first_name") String first_name,
			@Param(value="last_name") String last_name,
			@Param(value="city") String city,
			@Param(value="pincode") int pincode,
			@Param(value="number") String number,			
			@Param(value="date_of_birth") String date_of_birth,
			@Param(value="joining_date") String joining_date,
			@Param(value="user_id") int user_id);
	
}
