package com.loans.mortgage.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loans.mortgage.entity.Property;
import com.loans.mortgage.entity.User;
import com.loans.mortgage.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	

	@PostMapping("/checkOffer")
	public ResponseEntity<List<Property>>  addUserById(@RequestBody User user) throws Exception{

		Period diff = Period.between(user.getDob(), LocalDate.now());
		
		if( diff.getYears()<25) throw new Exception("age should be greater then 25");
		
		if(user.getFirstName()==null||user.getLastName()==null||user.getGender()==null||
				user.getPan()==null||user.getDob()==null||user.getAddress()==null||
				user.getPincode()==0||user.getSqft()==0) {
			throw new Exception("enter complete data");
		}
		
		if(user.getSalary()<100000) throw new Exception("not eligible for loan low salary");
		
		return new ResponseEntity<List<Property>>(userService.checkOffer(user),HttpStatus.OK);
		
	}


}
