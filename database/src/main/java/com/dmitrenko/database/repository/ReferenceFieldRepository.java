package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceFieldRepository extends JpaRepository<ReferenceField, Long> {
}
