package com.dmitrenko.itemmatchingservice.repository;

import com.dmitrenko.itemmatchingservice.domain.ReplacementWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplacementWordRepository extends JpaRepository<ReplacementWord, Long> {
	boolean existsByReplaceable(String replaceable);
}
