package com.example.demo.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity class with Lombok
@Data
@Entity
@Table(name="User_Table2")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private  int user_id;
	private  String firstName;
	private  String lastName;
	private  String number;
	private  String date_of_birth;
	private  String joining_date;
	private  String city;
	private  int pincode;
	
	


}
