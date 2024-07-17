package com.todoApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoApp.model.TodoModel;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {
	@Autowired
	List<TodoModel> findByUserEmail(String email);

}
