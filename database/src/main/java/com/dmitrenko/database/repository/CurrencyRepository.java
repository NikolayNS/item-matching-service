package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
