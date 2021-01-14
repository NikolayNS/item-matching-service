package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.reference.ReferenceField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferenceFieldRepository extends JpaRepository<ReferenceField, Long> {
	Optional<ReferenceField> findByBarcode(String barcode);

	void deleteByReferenceId(Long referenceId);

	boolean existsByReferenceId(Long referenceId);
}
