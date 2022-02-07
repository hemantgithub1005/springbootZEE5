package com.zee.zee5app.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Register;

public interface UserRepository extends JpaRepository<Register, String> {
	
	//custom jpa method
	Boolean existsByEmailAndContactNumber(String email,BigDecimal contactNumber);
	

}
