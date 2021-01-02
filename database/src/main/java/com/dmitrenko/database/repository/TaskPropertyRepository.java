package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.task.TaskProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskPropertyRepository extends JpaRepository<TaskProperty, Long> {
}
