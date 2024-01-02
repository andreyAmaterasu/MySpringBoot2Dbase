package com.example.MySpringBoot2Dbase.dao;

import com.example.MySpringBoot2Dbase.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class StudentDAOImpl implements StudentDAO {

  private final EntityManager entityManager;

  @Override
  public List<Student> getAllStudents() {
    Query query = entityManager.createQuery("from Student ");
    List<Student> allStudents = query.getResultList();
    log.info("getAllStudents: {}", allStudents);
    return allStudents;
  }

  @Override
  public Student saveStudent(Student student) {
    return entityManager.merge(student);
  }

  @Override
  public Student getStudent(int id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public void deleteStudent(int id) {
    Query query = entityManager.createQuery("delete from Student where id = :studentId");
    query.setParameter("studentId", id);
    query.executeUpdate();
  }
}
