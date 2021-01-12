package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModifiedStringRepository extends JpaRepository<ModifiedString, Long> {
	Optional<ModifiedString> findByModifiable(String modifiable);
}
