package com.dmitrenko.itemmatchingservice.repository;

import com.dmitrenko.itemmatchingservice.domain.CompanyItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyItemRepository extends JpaRepository<CompanyItem, Long> {
	boolean existsByName(String name);
}
