package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.company.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyTypeReposytory extends JpaRepository<CompanyType, Long> {
}
