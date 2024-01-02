package com.example.MySpringBoot2Dbase.dao;

import com.example.MySpringBoot2Dbase.entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class SubjectDAOImpl implements SubjectDAO {

  private final EntityManager entityManager;

  @Override
  public List<Subject> getAllSubjects() {
    Query query = entityManager.createQuery("from Subject");
    List<Subject> allSubjects = query.getResultList();
    log.info("getAllStudents: {}", allSubjects);
    return allSubjects;
  }

  @Override
  public Subject saveSubject(Subject subject) {
    return entityManager.merge(subject);
  }

  @Override
  public Subject getSubject(int id) {
    return entityManager.find(Subject.class, id);
  }

  @Override
  public void deleteSubject(int id) {
    Query query = entityManager.createQuery("delete from Subject where id = :subjectId");
    query.setParameter("subjectId", id);
    query.executeUpdate();
  }
}