package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceTypeRepository extends JpaRepository<ReferenceType, Long> {
}
