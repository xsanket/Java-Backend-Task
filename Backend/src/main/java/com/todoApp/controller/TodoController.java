package com.todoApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoApp.model.TodoModel;
import com.todoApp.repository.TodoRepository;
import com.todoApp.service.TodoService;
import com.todoApp.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@PostMapping("/save-task")
	public ResponseEntity<TodoModel> saveAllTask(@RequestBody TodoModel todoModel, @RequestParam String email) {
		try {
			TodoModel saveNewTask = todoService.saveTask(todoModel, email);
			return new ResponseEntity<>(saveNewTask, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/get-task")
	public ResponseEntity<List<TodoModel>> getAllTasks(@RequestParam String email) {
		try {
			List<TodoModel> getTasks = todoService.getTaskByUser(email);
			return new ResponseEntity<>(getTasks, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
