package com.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoApp.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	UserModel findByEmail(String email);

}
