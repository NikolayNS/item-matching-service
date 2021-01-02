package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
