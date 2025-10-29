package com.example.webapp.form;

import lombok.Data;

@Data
public class TodoForm {
  
  private Integer id;
  private String todo;
  private String detail;
  private Boolean isNew;

}
