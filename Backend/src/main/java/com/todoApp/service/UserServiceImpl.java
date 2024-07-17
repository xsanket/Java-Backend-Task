package com.todoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.DTO.LoginRequest;
import com.todoApp.exception.DuplicateEmailException;
import com.todoApp.model.UserModel;
import com.todoApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	// service logic to save user in db
	@Override
	public UserModel saveUser(UserModel userModel) {
		String email = userModel.getEmail();
		UserModel isExistingUser = userRepo.findByEmail(email);
		if (isExistingUser != null) {
			throw new DuplicateEmailException("Email already exist: " + email);
		}
		return userRepo.save(userModel);
	}

	
	@Override
	public UserModel authenticateUser(String email, String password) {
		UserModel user = userRepo.findByEmail(email);	
		if(user != null &&  password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

}
