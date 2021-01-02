package com.dmitrenko.database.repository;

import com.dmitrenko.database.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
