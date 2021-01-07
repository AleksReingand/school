package com.aleks.schools.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class School
{
  private int schoolId;
  private String name;
//  private Collection<Employee> employeesBySchoolId;
//  private Collection<Student> studentsBySchoolId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "school_id", table = "school", nullable = false)
  public int getSchoolId()
  {
    return schoolId;
  }

  public void setSchoolId(int schoolId)
  {
    this.schoolId = schoolId;
  }

  @Basic
  @Column(name = "name", table = "school", nullable = false, length = 100)
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    School school = (School) o;
    return schoolId == school.schoolId && Objects.equals(name, school.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(schoolId, name);
  }

//  @OneToMany(mappedBy = "schoolBySchoolId")
//  public Collection<Employee> getEmployeesBySchoolId()
//  {
//    return employeesBySchoolId;
//  }
//
//  public void setEmployeesBySchoolId(Collection<Employee> employeesBySchoolId)
//  {
//    this.employeesBySchoolId = employeesBySchoolId;
//  }
//
//  @OneToMany(mappedBy = "schoolBySchoolId")
//  public Collection<Student> getStudentsBySchoolId()
//  {
//    return studentsBySchoolId;
//  }
//
//  public void setStudentsBySchoolId(Collection<Student> studentsBySchoolId)
//  {
//    this.studentsBySchoolId = studentsBySchoolId;
//  }
}
