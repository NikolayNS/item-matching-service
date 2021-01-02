package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.task.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
}
