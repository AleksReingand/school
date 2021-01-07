package com.aleks.schools.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "subject_id", table = "subject", nullable = false)
  private int subjectId;

  @Basic
  @Column(name = "name", table = "subject", nullable = false, length = 100)
  private String name;

  @ManyToMany
  @JoinTable(name = "employee_subject",
          joinColumns = {@JoinColumn(referencedColumnName = "subject_id")},
          inverseJoinColumns = {@JoinColumn(referencedColumnName = "employee_id")})
  private Set<Employee> employees;
}
