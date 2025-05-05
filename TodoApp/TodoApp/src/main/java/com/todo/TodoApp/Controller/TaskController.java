package com.todo.TodoApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.TodoApp.Model.Task;
import com.todo.TodoApp.Service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public String getTask(Model model) {
		List<Task> task = service.getAllTask();
		model.addAttribute("tasks", task);
		return "tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		service.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable int id) {
		service.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable int id) {
		service.toggleTask(id);
		return "redirect:/";
	}

}
