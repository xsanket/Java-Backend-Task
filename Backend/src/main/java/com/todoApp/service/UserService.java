package com.todoApp.service;

import com.todoApp.DTO.LoginRequest;
import com.todoApp.model.UserModel;

public interface UserService {

	UserModel saveUser(UserModel userModel);

	UserModel authenticateUser(String email, String password);

}
