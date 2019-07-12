package com.loans.mortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loans.mortgage.entity.Offer;
import com.loans.mortgage.entity.Property;
import com.loans.mortgage.entity.User;
import com.loans.mortgage.repository.OfferRepository;
import com.loans.mortgage.repository.PropertyRepository;
import com.loans.mortgage.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	OfferRepository offerRepository;

	@Autowired
	PropertyRepository propertyRepository;
	


		

	

	public List<Property> checkOffer(User user) {
		userRepository.save(user);
		Offer offer = offerRepository.findByPincode(user.getPincode());

		Double propertyvalue=(double) (user.getSqft()*offer.getSqFt());
		Double loanAmount=propertyvalue*0.8;
		
		if(propertyvalue<500000) {
			Property property = new Property();
			property.setMsg("not eligible due to low loan amount");
		}
		
		return propertyRepository.findByLoanAmount(loanAmount);

	}
}


