package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Todo;
import com.example.webapp.repository.TodoMapper;
import com.example.webapp.service.TodoService;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
  
  private final TodoMapper todoMapper;
  
  public TodoServiceImpl( TodoMapper todoMapper ) {
    this.todoMapper = todoMapper;
  }
  
  
  
  @Override
  public List<Todo> findAllTodo() {
    return todoMapper.selectAll();
  }
  
  @Override
  public Todo findByIdTodo( Integer id ) {
    return todoMapper.selectById( id );
  }
  
  @Override
  public void insertTodo( Todo todo ) {
    todoMapper.insert( todo );
  }
  
  @Override
  public void updateTodo( Todo todo ) {
    todoMapper.update( todo );
  }
  
  @Override
  public void deleteTodo( Integer id ) {
    todoMapper.delete( id );
  }

}
