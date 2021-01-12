package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.company.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

	Optional<CompanyType> findByName(String name);
}
