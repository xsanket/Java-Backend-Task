package com.todoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.model.TodoModel;
import com.todoApp.model.UserModel;
import com.todoApp.repository.TodoRepository;
import com.todoApp.repository.UserRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepo;
	@Autowired
	private UserRepository userRepo;
//	public TodoServiceImpl(TodoRepository todoRepo) {
//		super();
//		this.todoRepo = todoRepo;
//	}
//
//	public TodoServiceImpl(UserRepository userRepo) {
//		super();
//		this.userRepo = userRepo;
//	}




	@Override
	public TodoModel saveTask (TodoModel todoModel, String email) {
		UserModel user = userRepo.findByEmail(email);
		todoModel.setUser(user);
		return todoRepo.save(todoModel);
		
		//return todoRepo.save(todoModel);
	}

	public List<TodoModel> getTaskByUser(String email){
		return todoRepo.findByUserEmail(email);
	}

	public TodoServiceImpl() {
		super();
	}

}
