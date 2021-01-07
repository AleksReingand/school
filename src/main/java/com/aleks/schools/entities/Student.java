package com.aleks.schools.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Student
{
  private int studentId;
  private String name;
  private Integer age;
//  private School schoolBySchoolId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id", table = "student", nullable = false)
  public int getStudentId()
  {
    return studentId;
  }

  public void setStudentId(int studentId)
  {
    this.studentId = studentId;
  }

  @Basic
  @Column(name = "name", table = "student", nullable = false, length = 100)
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Basic
  @Column(name = "age", table = "student", nullable = true)
  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    Student student = (Student) o;
    return studentId == student.studentId && Objects.equals(name, student.name) && Objects.equals(age, student.age);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(studentId, name, age);
  }

//  @ManyToOne
//  @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false, table = "student")
//  public School getSchoolBySchoolId()
//  {
//    return schoolBySchoolId;
//  }
//
//  public void setSchoolBySchoolId(School schoolBySchoolId)
//  {
//    this.schoolBySchoolId = schoolBySchoolId;
//  }
}
