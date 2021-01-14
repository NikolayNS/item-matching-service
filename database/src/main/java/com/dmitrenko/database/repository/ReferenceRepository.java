package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
	Optional<Reference> findByName(String name);
}
