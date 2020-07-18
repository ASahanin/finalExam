package com.example.demo.service;

import com.example.demo.model.TaskModel;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task getById(Long id);
    Task create(Task task);
    Task create(TaskModel taskModel, String userLogin);
    Task update(Task task);
    Task deleteById(Long id);

    List<Task> getAllByUserLogin(String login);
    List<Task> searchByTitle(String title);
    List<Task> searchByText(String text);
}
