package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
