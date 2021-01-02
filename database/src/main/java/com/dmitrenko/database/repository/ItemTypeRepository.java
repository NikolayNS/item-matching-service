package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
}
