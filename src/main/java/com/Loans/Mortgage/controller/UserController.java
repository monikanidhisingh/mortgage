package com.loans.mortgage.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
	public ResponseEntity<List<Property>>  addUserById(@RequestBody User user){

		List<Property> properties=new ArrayList<Property>();
		Period diff = Period.between(user.getDob(), LocalDate.now());

		if( diff.getYears()<25) { 
			Property property = new Property();
			property.setMsg("age should be greater then 25");
			properties.add(property);
		}

		else if(user.getFirstName()==null||user.getLastName()==null||user.getGender()==null||
				user.getPan()==null||user.getDob()==null||user.getAddress()==null||
				user.getPincode()==0||user.getSqft()==0) {
			Property property = new Property();
			property.setMsg("enter complete data");
			properties.add(property);
		}

		else if(user.getSalary()<100000) { 
			Property property = new Property();
			property.setMsg("low salary");
			properties.add(property);
			}else {
				properties = userService.checkOffer(user);
			}

		return new ResponseEntity<>(properties,HttpStatus.OK);

	}


}
