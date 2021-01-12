package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceTypeRepository extends JpaRepository<ReferenceType, Long> {
}
