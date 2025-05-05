package com.todo.TodoApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TodoApp.Model.Task;
import com.todo.TodoApp.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;

	public List<Task> getAllTask() {
		return repository.findAll(); 
	}

	public void createTask(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleted(false);
		repository.save(task);
		
	}

	public void deleteTask(int id) {
		repository.deleteById(id);
	}

	public void toggleTask(int id) {
		Task task = repository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid task Id"));
		task.setCompleted(!task.isCompleted());
		repository.save(task);

	}

}
