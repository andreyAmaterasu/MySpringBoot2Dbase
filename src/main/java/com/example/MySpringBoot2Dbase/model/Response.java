package com.example.MySpringBoot2Dbase.model;

import com.example.MySpringBoot2Dbase.entity.Student;
import java.util.List;
import lombok.Data;

@Data
public class Response {

  private String status;
  private List<Student> students;
}
