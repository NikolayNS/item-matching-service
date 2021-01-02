package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.ItemModifiedString;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemModifiedStringRepository extends JpaRepository<ItemModifiedString, Long> {
}
