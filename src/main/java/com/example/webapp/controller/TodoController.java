package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.Todo;
import com.example.webapp.form.TodoForm;
import com.example.webapp.service.TodoService;
import com.example.webapp.tools.TodoTools;

@Controller
public class TodoController {
  
  private final TodoService todoService;
  
  public TodoController( TodoService todoService ) {
    this.todoService = todoService;
  }
  
  
  
  @GetMapping( "/todos" )
  public String list( Model model ) {
    model.addAttribute( "todos", todoService.findAllTodo() );
    return "todo/list";
  }
  
  
  
  @GetMapping( "/todos/{id}" )
  public String detail( @PathVariable Integer id, Model model, RedirectAttributes attributes ) {
    
    Todo todo = todoService.findByIdTodo( id );
    if ( todo != null ) {
      model.addAttribute( "todo", todo );
      return "todo/detail";
    } else {
      attributes.addFlashAttribute( "errorMessage", "対象データがありません" );
      return "redirect:/todos";
    }
  }
  
 
  
  @GetMapping( "/todos/form" )
  public String newTodo( TodoForm todoForm ) {
    todoForm.setIsNew( true );
    return "todo/form";
  }
  
  
  
  @PostMapping( "/todos/save" )
  public String create( @Validated TodoForm todoForm,
      BindingResult bindingResult,
      RedirectAttributes attributes ) {
    
    System.out.println( bindingResult );
    if ( bindingResult.hasErrors() ) {
      todoForm.setIsNew( true );
      return "todo/form";
    }
    Todo todo = TodoTools.TodoF2E( todoForm );
    todoService.insertTodo( todo );
    attributes.addFlashAttribute( "message", "新しいTodoが作成されました" );
    return "redirect:/todos";
  }

  
  
  @GetMapping( "/todos/edit/{id}" )
  public String edit( @PathVariable Integer id, Model model, RedirectAttributes attributes ) {
    Todo todo = todoService.findByIdTodo( id );
    if ( todo != null ) {
      TodoForm todoForm = TodoTools.TodoE2F( todo );
      model.addAttribute( "todoForm", todoForm );
      return "todo/form";
    }
    attributes.addFlashAttribute( "errorMessage", "対象データがありません" );
    return "redirect:/todos";
  }
  
  
  
  @PostMapping( "/todos/update" )
  public String update( @Validated TodoForm todoForm,
      BindingResult bindingResult,
      RedirectAttributes attributes ) {
    
    if ( bindingResult.hasErrors() ) {
      todoForm.setIsNew( false );
      return "todo/form";
    }
    Todo todo = TodoTools.TodoF2E( todoForm );
    todoService.updateTodo( todo );
    attributes.addFlashAttribute( "message", "Todoが更新されました" );
    return "redirect:/todos";
  }
  
  
  
  @PostMapping( "/todos/delete/{id}" )
  public String delete( @PathVariable Integer id, RedirectAttributes attributes ) {
    todoService.deleteTodo( id );
    attributes.addFlashAttribute( "message", "Todoが削除されました" );
    return "redirect:/todos";
  }
  
  
  
}
