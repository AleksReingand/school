package com.aleks.schools.repository;

import com.aleks.schools.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer>
{
}
