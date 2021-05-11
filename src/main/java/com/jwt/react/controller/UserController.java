package com.jwt.react.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.react.conveter.UserConveter;
import com.jwt.react.dto.UserDto;
import com.jwt.react.entity.RoleName;
import com.jwt.react.repository.RoleRepository;
import com.jwt.react.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserConveter userConveter;
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUsr(@Valid @RequestBody UserDto userDto){
		if(userRepository.existsByUsername(userDto.getUsername())) {
			return new ResponseEntity<String>("Fail->User name is already taken",HttpStatus.BAD_REQUEST);  //(new ResponseMessage("Fail->User name is already taken"),HttpStatus.BAD_REQUEST)
		}
		if(userRepository.existsByEmail(userDto.getEmail())){
			return new ResponseEntity<String>("Fail->User name is already taken",HttpStatus.BAD_REQUEST);
		}
		userRepository.save(userConveter.signUpConveter(userDto));
		return new ResponseEntity<String>("user "+ userDto.getUsername()+" is Added",HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public String get() {
		return "Hello";
	}
}
