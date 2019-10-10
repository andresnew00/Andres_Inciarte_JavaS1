package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/tasks")
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();
    }

    @PostMapping
    public TaskViewModel createTask(@RequestBody @Valid Task task) {
        return service.newTask(task);
    }

    @PutMapping
    public void updateTask(@RequestBody @Valid Task task) {
        service.updateTask(task);
    }

    @GetMapping("/{id}")
    public TaskViewModel taskById(@PathVariable int id) {
        return service.fetchTask(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @GetMapping("/category/{category}")
    public List<TaskViewModel> getTaskByCategory(@PathVariable String category) {
        return service.fetchTasksByCategory(category);
    }

}
