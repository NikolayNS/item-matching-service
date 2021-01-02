package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {
}
