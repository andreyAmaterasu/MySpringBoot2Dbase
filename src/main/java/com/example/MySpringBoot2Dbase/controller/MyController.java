package com.example.MySpringBoot2Dbase.controller;

import com.example.MySpringBoot2Dbase.entity.Student;
import com.example.MySpringBoot2Dbase.model.Response;
import com.example.MySpringBoot2Dbase.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MyController {

  private final StudentService studentService;

  @GetMapping("/students")
  public ResponseEntity<Response> allStudents() {

    return getResponseEntity(studentService::getAllStudents);
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Response> getStudent(@PathVariable("id") int id) {

    return getResponseEntity(() -> List.of(studentService.getStudent(id)));
  }

  @PostMapping("/students")
  public ResponseEntity<Response> saveStudent(@RequestBody Student student) {

    return getResponseEntity(() -> List.of(studentService.saveStudent(student)));
  }

  @PutMapping("/students")
  public ResponseEntity<Response> updateStudent(@RequestBody Student student) {

    return getResponseEntity(() -> List.of(studentService.saveStudent(student)));
  }

  @DeleteMapping("/students/{id}")
  public void deleteStudent(@PathVariable("id") int id) {
    studentService.deleteStudent(id);
  }

  private ResponseEntity<Response> getResponseEntity(Supplier<List<Student>> supplier) {

    Response response = new Response();
    response.setStudents(new ArrayList<>());
    try {
      response.getStudents().addAll(supplier.get());
      response.setStatus("success");
    } catch (Exception e) {
      response.setStatus("failed");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
