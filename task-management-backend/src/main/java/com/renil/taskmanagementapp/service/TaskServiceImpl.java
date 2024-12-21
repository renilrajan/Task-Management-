package com.renil.taskmanagementapp.service;

import com.renil.taskmanagementapp.model.Task;
import com.renil.taskmanagementapp.repository.TaskRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renil.taskmanagementapp.model.Task;
import com.renil.taskmanagementapp.repository.TaskRepository;


import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        logger.info("Fetching all tasks");
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            logger.warn("No tasks found");
        }
        return tasks;
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        logger.info("Fetching task with id: {}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Task not found with id: {}", id);
                    return new TaskNotFoundException("Task not found with id: " + id);
                });
    }

    @Override
    public Task createTask(Task task) {
        logger.info("Creating new task: {}", task);
        validateTask(task);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        logger.info("Updating task with id: {}", id);
        if (!taskRepository.existsById(id)) {
            logger.error("Cannot update task. Task not found with id: {}", id);
            throw new Exception("Cannot update task. Task not found with id: " + id);
        }
        updatedTask.setId(id);
        validateTask(updatedTask);
        return taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        logger.info("Deleting task with id: {}", id);
        if (!taskRepository.existsById(id)) {
            logger.error("Cannot delete task. Task not found with id: {}", id);
            throw new Exception("Cannot delete task. Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    private void validateTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            logger.error("Task validation failed: Title is missing");
            throw new IllegalArgumentException("Task title is required");
        }
        // Add more validations as necessary
    }
}

