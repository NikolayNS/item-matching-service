package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.brandname.BrandName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandNameRepository extends JpaRepository<BrandName, Long> {

	Optional<BrandName> findByName(String name);
}
