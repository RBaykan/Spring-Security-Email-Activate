package com.nontius.proje.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nontius.proje.dto.UserDTO;
import com.nontius.proje.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/user")
public class UserController {
	
	
	private final UserService service;
	
	public UserController(UserService service){
		this.service = service;
	}

	@GetMapping()
	public List<UserDTO> allUser(){
		return service.getAllUser();
	}
	
	
	@PostMapping()
	public UserDTO register(@RequestBody @Valid UserDTO user) {
		
		
		
		return service.registerNewUser(user);
	}
	
	@GetMapping("/registrationConfirm")
	public String confirmRegistration(@RequestParam("token") String token) {
		
		
		return service.confirmRegistration(token);
		
	}
	
	
}
