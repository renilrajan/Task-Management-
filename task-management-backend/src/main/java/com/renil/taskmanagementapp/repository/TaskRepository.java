package com.renil.taskmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renil.taskmanagementapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}