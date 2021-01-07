package com.aleks.schools.entities;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {
  private int employerId;
  private String name;
  private String type;
//  private School schoolBySchoolId;
//  private Set<Subject> subjects;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id", table = "employee", nullable = false)
  public int getEmployerId()
  {
    return employerId;
  }

  public void setEmployerId(int employerId)
  {
    this.employerId = employerId;
  }

  @Basic
  @Column(name = "name", table = "employee", nullable = false, length = 100)
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Basic
  @Column(name = "type", table = "employee", nullable = true, length = 100)
  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

//  @ManyToMany
//  @JoinTable(name = "employee_subject",
//          joinColumns = {@JoinColumn(referencedColumnName = "employee_id")},
//          inverseJoinColumns = {@JoinColumn(referencedColumnName = "subject_id")})
//  public Set<Subject> getSubjects()
//  {
//    return subjects;
//  }
//
//  public void setSubjects(Set<Subject> subjects)
//  {
//    this.subjects = subjects;
//  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    Employee employee = (Employee) o;
    return employerId == employee.employerId && Objects.equals(name, employee.name) && Objects.equals(type, employee.type);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(employerId, name, type);
  }

//  @ManyToOne
//  @JoinColumn(name = "school_id", referencedColumnName = "school_id", table = "employee")
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
