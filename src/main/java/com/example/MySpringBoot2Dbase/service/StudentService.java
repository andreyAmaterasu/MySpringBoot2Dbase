package com.example.MySpringBoot2Dbase.service;

import com.example.MySpringBoot2Dbase.entity.Student;
import java.util.List;

public interface StudentService {

  List<Student> getAllStudents();

  Student saveStudent(Student student);

  Student getStudent(int id);

  void deleteStudent(int id);
}
