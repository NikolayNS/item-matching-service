package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.brandname.BrandName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandNameRepository extends JpaRepository<BrandName, Long> {

	Optional<BrandName> findByName(String name);
}
