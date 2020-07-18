package com.example.demo.controller;

import com.example.demo.model.TaskModel;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        HttpHeaders headers = new HttpHeaders();

        if (task == null) {
            headers.add("Message", "Couldn't find task with id " + id);
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        headers.add("Message", "OK");
        return new ResponseEntity<>(task, headers, HttpStatus.OK);
    }

    @PostMapping
    public Task create(@RequestBody TaskModel taskModel, Principal principal) {
        return taskService.create(taskModel, principal.getName());
    }


    @GetMapping("/my")
    public List<Task> getMyTasks(Principal principal) {
        return taskService.getAllByUserLogin(principal.getName());
    }
}
