package com.loans.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.loans.mortgage.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	
	
	@Query(value="select * from offer where pincode =?1",nativeQuery=true)
	 Offer findByPincode(int pincode);

}
