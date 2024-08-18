package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
