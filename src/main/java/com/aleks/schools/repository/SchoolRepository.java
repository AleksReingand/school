package com.aleks.schools.repository;

import com.aleks.schools.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer>
{
}
