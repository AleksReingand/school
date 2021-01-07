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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_id", table = "student", nullable = false)
  private int studentId;

  @Basic
  @Column(name = "name", table = "student", nullable = false, length = 100)
  private String name;

  @Basic
  @Column(name = "age", table = "student", nullable = true)
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "school_id", referencedColumnName = "school_id", nullable = false, table = "student")
  private School schoolBySchoolId;
}
