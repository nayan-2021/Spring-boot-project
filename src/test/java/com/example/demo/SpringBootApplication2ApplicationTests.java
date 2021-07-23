package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;



//test case class
@SpringBootTest
class SpringBootApplication2ApplicationTests {

     @Autowired
      UserRepository userRepo;
	// test case 1- for post api
     @Test
      public void testCreate() {
		User user= new User();
		user.setUser_id(1);
		user.setFirstName("Rohan");
		user.setLastName("Raut");
		user.setCity("Bishkek");
		user.setPincode(411000);
		user.setDate_of_birth("15-05-1995");
		user.setJoining_date("20-02-2020");
		userRepo.save(user);
		assertNotNull(userRepo.findById(9).get());
		
	}
     
     // test case 2- for get (all) api
	@Test
	public void testReadAll() {
		List<User> list=userRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	// test case 3- for get (single user) api
	@Test
	public void testSingleUser() {
		User user=userRepo.findById(3).get();
		assertEquals("MS",user.getFirstName());
	}
	
	//test case 4- for delete api
	@Test
	public void testDelete() {
		userRepo.deleteById(10);
		assertThat(userRepo.existsById(2)).isFalse();
	}
	
	//test case 5- for update api
	@Test
	public void testUpdate() {
		User user=userRepo.findById(4).get();
		user.setFirstName("Aniket");
		userRepo.save(user);
		assertNotEquals("Sachin", userRepo.findById(4).get().getFirstName());
	}
	
}
