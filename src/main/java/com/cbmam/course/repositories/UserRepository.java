package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
