package com.trilogyed.tasker.service;

import com.trilogyed.tasker.controller.TaskerController;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TaskerServiceLayer {

    @Autowired
    TaskerDao dao;

    @Autowired
    AdServiceClient adServiceClient;

    @Autowired
    TaskerServiceLayer taskerServiceLayer;


    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // get ad from Adserver and put in tvm
        tvm.setAdvertisement(adServiceClient.getAd());
        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        List<Task> tasks = dao.getAllTasks();

        tasks.forEach(task -> taskViewModels.add(fetchTask(task.getId())));

        return taskViewModels;

    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        List<Task> tasks = dao.getTasksByCategory(category);

        tasks.forEach(task -> taskViewModels.add(fetchTask(task.getId())));

        return taskViewModels;
    }

    public TaskViewModel newTask(Task task) {

        task = dao.createTask(task);

        TaskViewModel tvm = new TaskViewModel();

        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        tvm.setId(task.getId());

        // get ad from Adserver and put in taskViewModel
        tvm.setAdvertisement(adServiceClient.getAd());

        return tvm;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    public void updateTask(Task task) {
        dao.updateTask(task);
    }
}
