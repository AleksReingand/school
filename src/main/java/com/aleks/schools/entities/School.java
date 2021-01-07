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
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "school_id", table = "school", nullable = false)
  private int schoolId;

  @Basic
  @Column(name = "name", table = "school", nullable = false, length = 100)
  private String name;

  @OneToMany(mappedBy = "schoolBySchoolId")
  private Collection<Employee> employeesBySchoolId;

  @OneToMany(mappedBy = "schoolBySchoolId")
  private Collection<Student> studentsBySchoolId;
}
