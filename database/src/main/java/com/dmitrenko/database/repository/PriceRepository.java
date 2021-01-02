package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
