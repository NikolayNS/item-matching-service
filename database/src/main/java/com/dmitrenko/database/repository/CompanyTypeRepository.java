package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.company.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

	Optional<CompanyType> findByName(String name);
}
