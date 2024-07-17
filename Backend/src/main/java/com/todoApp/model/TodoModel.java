package com.todoApp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class TodoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long todoId;
	private Date date;
	private String task;
	private boolean isComplete= false;
	
	
	@ManyToOne ()
	@JoinColumn (name="user_email", referencedColumnName = "email")
	@JsonBackReference
	private UserModel user;


	


	public TodoModel(Date date, String task, boolean isComplete, UserModel user) {
		super();
		this.date = date;
		this.task = task;
		this.isComplete = isComplete;
		this.user = user;
	}


	public TodoModel() {
		super();
	}


	public long getTodoId() {
		return todoId;
	}


	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getTask() {
		return task;
	}


	public void setTask(String task) {
		this.task = task;
	}


	public boolean isComplete() {
		return isComplete;
	}


	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}


	public UserModel getUser() {
		return user;
	}


	public void setUser(UserModel user) {
		this.user = user;
	}
	

	
	
	
	
	
	
	
}
