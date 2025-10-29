package com.example.webapp.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Todo {
  
  private Integer id;
  private String todo;
  private String detail;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
