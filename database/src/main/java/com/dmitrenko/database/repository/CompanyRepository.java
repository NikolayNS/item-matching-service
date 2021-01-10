package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	Optional<Company> findByName(String name);
}
