package com.aleks.schools.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "employee_id", table = "employee", nullable = false)
  private int employerId;

  @Basic
  @Column(name = "name", table = "employee", nullable = false, length = 100)
  private String name;

  @Basic
  @Column(name = "type", table = "employee", nullable = true, length = 100)
  private String type;

  @ManyToOne
  @JoinColumn(name = "school_id", referencedColumnName = "school_id", table = "employee")
  private School schoolBySchoolId;

  @ManyToMany
  @JoinTable(name = "employee_subject",
          joinColumns = {@JoinColumn(referencedColumnName = "employee_id")},
          inverseJoinColumns = {@JoinColumn(referencedColumnName = "subject_id")})
  private Set<Subject> subjects;
}
