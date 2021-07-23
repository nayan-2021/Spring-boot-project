package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

// Controller class
@RestController
@RequestMapping("/user")
public class HomeController {

	@Autowired
	private UserRepository userRepo;

   //Sorting user by date of birth
    @GetMapping("/users/sorting_by_date_of_birth")
	public List<User> getUserssorting_by_date_of_birth() {
		List<User> list =userRepo.findAll();
		List<User> listSorted = new ArrayList<User>();
		User user=new User();
		
	    Comparator<User>  NameCommparator = Comparator.comparing(User::getDate_of_birth);
	    
	    listSorted = list.stream().sorted(NameCommparator).collect(Collectors.toList());
        return listSorted;
	}

    //Sorting user by joining date
    @GetMapping("/users/sorting_by_joiningDate")
	public List<User> getUserssorting_by_joiningDate() {
		List<User> list =userRepo.findAll();
		List<User> listSorted = new ArrayList<User>();
		User user=new User();
		
	    Comparator<User>  NameCommparator = Comparator.comparing(User::getJoining_date);
	    
	    listSorted = list.stream().sorted(NameCommparator).collect(Collectors.toList());
        return listSorted;
	}
    
    // Get api for getting list of all users
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
     
	//Get api for getting user by firstName
	@GetMapping("/users/firstName/{firstName}")
	public List<User> getUsersByFirstName(@PathVariable String firstName) {

		return userRepo.getListByfirstName(firstName);
	}
   
	//Get api for getting user by lastName
	@GetMapping("/users/lastName/{lastName}")
	public List<User> getUsersByLastName(@PathVariable String lastName) {
		return userRepo.getListBylastName(lastName);
	}
     
	//Get api for getting user by pincode
	@GetMapping("/users/pincode/{pinCode}")
	public List<User> getUsersBypinCode(@PathVariable int pinCode) {
		return userRepo.getListbyPincode(pinCode);

	}
    
	//Put api for updating user
	 @PutMapping("/update")
	 public void updateUser(@RequestBody User user) {
	  userRepo.updateUser_table2(user.getFirstName(), user.getLastName(),
	  user.getCity(), user.getPincode(), user.getNumber(), user.getDate_of_birth(),
	  user.getJoining_date(), user.getUser_id());}
	 
    
	 //Delete api for deleting user for id
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
		return "Record deleted successfully " + id;
	}
 
   // Post api for adding user
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepo.save(user);
	}

}
