package com.example.MySpringBoot2Dbase.model;

import com.example.MySpringBoot2Dbase.entity.Subject;
import java.util.List;
import lombok.Data;

@Data
public class SubjectResponse {

  private String status;
  private List<Subject> subjects;
}

