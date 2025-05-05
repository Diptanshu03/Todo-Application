package com.todo.TodoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.TodoApp.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
