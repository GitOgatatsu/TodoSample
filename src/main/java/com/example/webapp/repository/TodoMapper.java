package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.Todo;

@Mapper
public interface TodoMapper {
  
  List<Todo> selectAll();
  
  Todo selectById( @Param( "id" ) Integer id );
  
  void insert( Todo todo );
  
  void update( Todo todo );
  
  void delete( @Param( "id" ) Integer id );

}
