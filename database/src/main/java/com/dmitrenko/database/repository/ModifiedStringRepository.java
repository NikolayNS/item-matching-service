package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.ModifiedString;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModifiedStringRepository extends JpaRepository<ModifiedString, Long> {
}
