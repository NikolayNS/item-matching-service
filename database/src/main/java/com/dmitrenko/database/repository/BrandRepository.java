package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.brandname.BrandName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandName, Long> {
}
