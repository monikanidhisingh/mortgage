package com.loans.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loans.mortgage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findUserByPan(User user);
	
	public List<User> findUserByPanIsNotLike(String Pan);

}
