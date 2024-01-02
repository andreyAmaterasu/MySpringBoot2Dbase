package com.example.MySpringBoot2Dbase.service;

import com.example.MySpringBoot2Dbase.dao.SubjectDAO;
import com.example.MySpringBoot2Dbase.entity.Subject;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

  private final SubjectDAO subjectDAO;

  @Override
  @Transactional
  public List<Subject> getAllSubjects() {
    return subjectDAO.getAllSubjects();
  }

  @Override
  @Transactional
  public Subject saveSubject(Subject subject) {
    return subjectDAO.saveSubject(subject);
  }

  @Override
  @Transactional
  public Subject getSubject(int id) {
    return subjectDAO.getSubject(id);
  }

  @Override
  @Transactional
  public void deleteSubject(int id) {
    subjectDAO.deleteSubject(id);
  }
}
