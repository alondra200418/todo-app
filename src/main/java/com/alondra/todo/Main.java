package com.alondra.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/tasks")
public class Main {

    @Autowired
    private TodoService service;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // This allows you to see all tasks at http://localhost:8080/tasks
    @GetMapping
    public List<String> getAllTasks() {
        return service.getTasks();
    }

    // This allows you to add tasks via a POST request
    // You can test this in your video demo using Postman or a browser
    @PostMapping
    public String addTask(@RequestParam String task) {
        service.addTask(task);
        return "Task '" + task + "' added successfully!";
    }
}