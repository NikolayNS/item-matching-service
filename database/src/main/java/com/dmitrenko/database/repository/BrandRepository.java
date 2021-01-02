package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.BrandName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandName, Long> {
}
