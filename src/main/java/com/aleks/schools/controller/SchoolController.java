package com.aleks.schools.controller;

import com.aleks.schools.entities.Employee;
import com.aleks.schools.entities.School;
import com.aleks.schools.entities.Student;
import com.aleks.schools.entities.Subject;
import com.aleks.schools.repository.EmployeeRepository;
import com.aleks.schools.repository.SchoolRepository;
import com.aleks.schools.repository.StudentRepository;
import com.aleks.schools.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController
{
  @Autowired
  SchoolRepository schoolRepository;

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  SubjectRepository subjectRepository;

  @GetMapping("/school")
  public ResponseEntity<List<School>> getAllSchools()
  {
    List<School> schools = schoolRepository.findAll();
    if(schools.isEmpty())
    {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(schools, HttpStatus.OK);
  }

  @PostMapping("/school")
  public ResponseEntity<School> createSchool(@RequestBody School school)
  {
    School newSchool = schoolRepository.save(
                School.builder()
                        .schoolId(school.getSchoolId())
                        .name(school.getName())
                        .employeesBySchoolId(school.getEmployeesBySchoolId())
                        .studentsBySchoolId(school.getStudentsBySchoolId())
                        .build());
    return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
  }

  @GetMapping("/employee")
  public ResponseEntity<List<Employee>> getAllEmployees()
  {
    return null;
  }

  @PostMapping("/employee")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
  {
    return null;
  }

  @GetMapping("/student")
  public ResponseEntity<List<Student>> getAllStudents()
  {
    return null;
  }

  @PostMapping("/student")
  public ResponseEntity<Student> createStudent(@RequestBody Student student)
  {
    return null;
  }

  @GetMapping("/subject")
  public ResponseEntity<List<Subject>> getAllSubjects()
  {
    return null;
  }

  @PostMapping("/subject")
  public ResponseEntity<Subject> createSubject(@RequestBody Subject subject)
  {
    return null;
  }
}
