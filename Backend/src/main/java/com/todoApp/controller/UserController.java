package com.todoApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.DTO.LoginRequest;
import com.todoApp.exception.DuplicateEmailException;
import com.todoApp.model.UserModel;
import com.todoApp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	// instance of the user serviceimpl class
	private UserService userService;

	// constructor base dependency injection
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserModel userModel) {
		try {
			UserModel savedNewUser = userService.saveUser(userModel);
			return new ResponseEntity<>(savedNewUser, HttpStatus.CREATED);
		} catch (DuplicateEmailException e) {
			HashMap<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "Email already exist");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		try {
			UserModel user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
			if (user == null) {
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("message", "Invalid Email or Password");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}
			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
