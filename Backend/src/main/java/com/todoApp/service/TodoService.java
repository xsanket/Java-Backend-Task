package com.todoApp.service;

import java.util.List;

import com.todoApp.model.TodoModel;

public interface TodoService {
	
	TodoModel saveTask(TodoModel todoModel, String email);
	
	List<TodoModel> getTaskByUser(String email);
//	TodoModel getTask(TodoModel todoModel);

}
