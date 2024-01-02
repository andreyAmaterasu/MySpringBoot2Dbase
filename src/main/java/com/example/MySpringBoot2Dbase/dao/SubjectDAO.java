package com.example.MySpringBoot2Dbase.dao;

import com.example.MySpringBoot2Dbase.entity.Subject;
import java.util.List;

public interface SubjectDAO {

  List<Subject> getAllSubjects();

  Subject saveSubject(Subject subject);

  Subject getSubject(int id);

  void deleteSubject(int id);
}
