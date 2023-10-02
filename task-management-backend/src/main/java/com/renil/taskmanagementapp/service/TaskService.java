package com.renil.taskmanagementapp.service;

import java.util.List;
import java.util.Optional;

import com.renil.taskmanagementapp.model.Task;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}