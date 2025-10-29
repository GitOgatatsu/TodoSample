package com.example.webapp.tools;

import com.example.webapp.entity.Todo;
import com.example.webapp.form.TodoForm;

public class TodoTools {
  
  public static TodoForm TodoE2F( Todo todo ) {
    TodoForm todoForm = new TodoForm();
    todoForm.setTodo( todo.getTodo() );
    todoForm.setTodo( todo.getDetail() );
    todoForm.setIsNew( false );
    return todoForm;
  }
  
  public static Todo TodoF2E( TodoForm todoForm ) {
    Todo todo = new Todo();
    todo.setTodo( todoForm.getTodo() );
    todo.setDetail( todoForm.getDetail() );
    return todo;
  }

}
