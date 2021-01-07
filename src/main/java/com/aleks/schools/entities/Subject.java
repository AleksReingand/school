package com.aleks.schools.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Subject
{
  private int subjectId;
  private String name;
//  private Set<Employee> employees;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subject_id", table = "subject", nullable = false)
  public int getSubjectId()
  {
    return subjectId;
  }

  public void setSubjectId(int subjectId)
  {
    this.subjectId = subjectId;
  }

  @Basic
  @Column(name = "name", table = "subject", nullable = false, length = 100)
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

//  @ManyToMany
//  @JoinTable(name = "employee_subject",
//          joinColumns = {@JoinColumn(referencedColumnName = "subject_id")},
//          inverseJoinColumns = {@JoinColumn(referencedColumnName = "employee_id")})
//  public Set<Employee> getEmployees()
//  {
//    return employees;
//  }
//
//  public void setEmployees(Set<Employee> employees)
//  {
//    this.employees = employees;
//  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    Subject subject = (Subject) o;
    return subjectId == subject.subjectId && Objects.equals(name, subject.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(subjectId, name);
  }
}
