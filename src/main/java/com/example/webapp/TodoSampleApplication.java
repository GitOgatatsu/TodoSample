package com.example.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.webapp.entity.Todo;
import com.example.webapp.repository.TodoMapper;
import com.example.webapp.service.TodoService;

@SpringBootApplication
public class TodoSampleApplication implements CommandLineRunner {
  
  private final TodoMapper todoMapper;
  private final TodoService todoService;
  
  public TodoSampleApplication( TodoMapper todoMapper, TodoService todoService ) {
    this.todoMapper = todoMapper;
    this.todoService = todoService;
  }

  
  
	public static void main(String[] args) {
		SpringApplication.run(TodoSampleApplication.class, args);
	}
	
	@Override
	public void run( String... args ) throws Exception {
	  
	  System.out.println( "=== 全件検索 ===" );
	  for ( Todo row: todoMapper.selectAll() ) {
	    System.out.println( row );
	  }
	  
	  System.out.println( "=== 1件検索 ===" );
    System.out.println( todoMapper.selectById( 1 ) );
    
    Todo todo = new Todo();
    todo.setTodo( "リポジトリのテスト" );
    todo.setDetail( "DBへの登録処理" );
    todoMapper.insert( todo );
    System.out.println( "=== 登録確認 ===" );
    System.out.println( todoMapper.selectById( 4 ) );
    
    Todo target = todoMapper.selectById( 4 );
    target.setTodo( "リポジトリのテスト：更新" );
    target.setDetail( "DBへの更新処理" );
    todoMapper.update( target );
    System.out.println( "=== 更新確認 ===" );
    System.out.println( todoMapper.selectById( 4 ) );
    
    todoMapper.delete( 4 );
    System.out.println( "=== 削除確認 ===" );
    for ( Todo row: todoMapper.selectAll() ) {
      System.out.println( row );
    }
    
    System.out.println( "***** ここからサービス *****" );
    
    System.out.println( "=== 全件検索 ===" );
    for ( Todo row: todoService.findAllTodo() ) {
      System.out.println( row );
    }
    
    System.out.println( "=== 1件検索 ===" );
    System.out.println( todoService.findByIdTodo( 1 ) );
    
    todo.setTodo( "リポジトリのテスト" );
    todo.setDetail( "DBへの登録処理" );
    todoService.insertTodo( todo );
    System.out.println( "=== 登録確認 ===" );
    System.out.println( todoService.findByIdTodo( 5 ) );
    
    target = todoService.findByIdTodo( 5 );
    target.setTodo( "リポジトリのテスト：更新" );
    target.setDetail( "DBへの更新処理" );
    todoService.updateTodo( target );
    System.out.println( "=== 更新確認 ===" );
    System.out.println( todoService.findByIdTodo( 5 ) );
    
    todoService.deleteTodo( 5 );
    System.out.println( "=== 削除確認 ===" );
    for ( Todo row: todoService.findAllTodo() ) {
      System.out.println( row );
    }
	  
	}

}
