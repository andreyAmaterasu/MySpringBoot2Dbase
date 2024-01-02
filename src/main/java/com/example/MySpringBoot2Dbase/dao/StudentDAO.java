package com.example.MySpringBoot2Dbase.dao;

import com.example.MySpringBoot2Dbase.entity.Student;
import java.util.List;

public interface StudentDAO {

  List<Student> getAllStudents();

  Student saveStudent(Student student);

  Student getStudent(int id);

  void deleteStudent(int id);
}
