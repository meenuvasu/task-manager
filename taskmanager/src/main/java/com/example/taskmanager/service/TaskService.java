package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task task) {
        Task existing = taskRepository.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setCompleted(task.isCompleted());
        return taskRepository.save(existing);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
