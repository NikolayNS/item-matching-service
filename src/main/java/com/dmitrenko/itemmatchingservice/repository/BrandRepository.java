package com.dmitrenko.itemmatchingservice.repository;

import com.dmitrenko.itemmatchingservice.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	boolean existsByName(String name);
}
