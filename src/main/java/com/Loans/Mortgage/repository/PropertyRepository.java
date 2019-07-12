package com.loans.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loans.mortgage.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	@Query(value="select * from property where loan_amount<=:loanamount",nativeQuery=true)
	List<Property> findByLoanAmount(Double loanamount);
}
