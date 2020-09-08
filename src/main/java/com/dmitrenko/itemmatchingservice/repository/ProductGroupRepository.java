package com.dmitrenko.itemmatchingservice.repository;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
	boolean existsByName(String name);
}
