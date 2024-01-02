package com.example.MySpringBoot2Dbase.controller;

import com.example.MySpringBoot2Dbase.entity.Subject;
import com.example.MySpringBoot2Dbase.model.SubjectResponse;
import com.example.MySpringBoot2Dbase.service.SubjectService;
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
public class SubjectController {

  private final SubjectService subjectService;

  @GetMapping("/subjects")
  public ResponseEntity<SubjectResponse> allSubjects() {

    return getResponseEntity(subjectService::getAllSubjects);
  }

  @GetMapping("/subjects/{id}")
  public ResponseEntity<SubjectResponse> getSubject(@PathVariable("id") int id) {

    return getResponseEntity(() -> List.of(subjectService.getSubject(id)));
  }

  @PostMapping("/subjects")
  public ResponseEntity<SubjectResponse> saveStudent(@RequestBody Subject subject) {

    return getResponseEntity(() -> List.of(subjectService.saveSubject(subject)));
  }

  @PutMapping("/subjects")
  public ResponseEntity<SubjectResponse> updateStudent(@RequestBody Subject subject) {

    return getResponseEntity(() -> List.of(subjectService.saveSubject(subject)));
  }

  @DeleteMapping("/subjects/{id}")
  public void deleteSubject(@PathVariable("id") int id) {
    subjectService.deleteSubject(id);
  }

  private ResponseEntity<SubjectResponse> getResponseEntity(Supplier<List<Subject>> supplier) {

    SubjectResponse response = new SubjectResponse();
    response.setSubjects(new ArrayList<>());
    try {
      response.getSubjects().addAll(supplier.get());
      response.setStatus("success");
    } catch (Exception e) {
      response.setStatus("failed");
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
