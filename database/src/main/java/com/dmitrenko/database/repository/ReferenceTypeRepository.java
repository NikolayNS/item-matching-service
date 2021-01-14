package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferenceTypeRepository extends JpaRepository<ReferenceType, Long> {
	Optional<ReferenceType> findByName(String name);
}
