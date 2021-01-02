package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
