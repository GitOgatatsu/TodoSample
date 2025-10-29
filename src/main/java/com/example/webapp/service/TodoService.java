package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.Todo;

public interface TodoService {
  
  List<Todo> findAllTodo();
  
  Todo findByIdTodo( Integer id );
  
  void insertTodo( Todo todo );
  
  void updateTodo( Todo todo );
  
  void deleteTodo( Integer id );

}
