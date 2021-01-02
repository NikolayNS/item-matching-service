package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceFieldRepository extends JpaRepository<ReferenceField, Long> {
}
