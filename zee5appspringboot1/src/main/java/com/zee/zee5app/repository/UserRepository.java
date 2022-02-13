package com.zee.zee5app.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	

//	boolean existsByEmailAndContactNumber(String email, BigDecimal contactNumber);
//	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);

}
