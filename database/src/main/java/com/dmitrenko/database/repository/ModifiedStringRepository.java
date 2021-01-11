package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModifiedStringRepository extends JpaRepository<ModifiedString, Long> {
	Optional<ModifiedString> findByModifiable(String modifiable);
}
