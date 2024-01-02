package com.example.MySpringBoot2Dbase.service;

import com.example.MySpringBoot2Dbase.dao.StudentDAO;
import com.example.MySpringBoot2Dbase.entity.Student;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

  private final StudentDAO studentDAO;

  @Override
  @Transactional
  public List<Student> getAllStudents() {
    return studentDAO.getAllStudents();
  }

  @Override
  @Transactional
  public Student saveStudent(Student student) {
    return studentDAO.saveStudent(student);
  }

  @Override
  @Transactional
  public Student getStudent(int id) {
    return studentDAO.getStudent(id);
  }

  @Override
  @Transactional
  public void deleteStudent(int id) {
    studentDAO.deleteStudent(id);
  }
}
