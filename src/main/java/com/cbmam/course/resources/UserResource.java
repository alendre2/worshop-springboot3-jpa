package com.cbmam.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbmam.course.entities.User;

@RestController
@RequestMapping(value = "/users" )
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Alendre", "Alendre@gmail.com", "81991930420", "123456");
		
		return ResponseEntity.ok().body(u);
	}		
	
	
	}
