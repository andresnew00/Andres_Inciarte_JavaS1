package com.trilogyed.tasker.service;

import com.trilogyed.tasker.controller.TaskerController;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    TaskerDao dao;

    @Autowired
    AdServiceClient adServiceClient;


    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(adServiceClient.getAd());
        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        return null;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        return null;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(adServiceClient.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

    }
}
