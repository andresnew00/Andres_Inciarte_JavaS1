package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {

    TaskerServiceLayer serviceLayer;

    TaskerDao taskerDao;

    AdServiceClient client;

    public void setUpTaskerDaoMock() {

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);

        List<Task> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setId(5);
        task1.setDescription("description");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("category");

        Task task2 = new Task();
        task2.setDescription("description");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("category");
        tasks.add(task2);

        doReturn(task1).when(taskerDao).createTask(task2);
        doReturn(task1).when(taskerDao).getTask(5);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory("category");

    }

    public void setUpAdserverClientMock() {

        client = mock(AdServiceClient.class);
        doReturn("Random Ad").when(client).getAd();

    }

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpAdserverClientMock();

        serviceLayer = new TaskerServiceLayer();

    }

    @Test
    public void fetchAllTasks() {

        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);

        List<TaskViewModel> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("category");
        TaskViewModel task1tvm = serviceLayer.newTask(task1);
        tasks.add(task1tvm);

        Task task2 = new Task();
        task2.setDescription("description");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("category");
        TaskViewModel task2tvm = serviceLayer.newTask(task2);
        tasks.add(task2tvm);

        tasks = serviceLayer.fetchAllTasks();

        assertEquals(2, tasks.size());

    }

    @Test
    public void fetchTasksByCategory() {

        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);

        List<TaskViewModel> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("category");
        TaskViewModel task1tvm = serviceLayer.newTask(task1);
        tasks.add(task1tvm);

        Task task2 = new Task();
        task2.setDescription("Trim Hedges.");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("category");
        TaskViewModel task2tvm = serviceLayer.newTask(task2);
        tasks.add(task2tvm);

        List<TaskViewModel> tasks2 = serviceLayer.fetchTasksByCategory("category");

        assertEquals(2, tasks2.size());
    }

    @Test
    public void addGetTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);
        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        TaskViewModel task1tvm = serviceLayer.newTask(task1);

        TaskViewModel task2 = serviceLayer.fetchTask(5);

        assertEquals(task1tvm.toString(), task2.toString());
    }

    @Test
    public void deleteTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);
        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        TaskViewModel task1tvm = serviceLayer.newTask(task1);

        taskerDao.deleteTask(task1.getId());

        assertNull(task1);

    }

    @Test
    public void updateTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 21);
        LocalDate date2 = LocalDate.of(2020, 12, 21);
        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        TaskViewModel task1tvm = serviceLayer.newTask(task1);

        task1tvm.setDescription("description2");

        serviceLayer.updateTask(task1);

        verify(taskerDao).updateTask(any(Task.class));
    }



}