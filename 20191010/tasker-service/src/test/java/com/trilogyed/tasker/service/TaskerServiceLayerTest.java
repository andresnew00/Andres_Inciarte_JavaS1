package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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

        taskerDao = mock(TaskerDao.class);
        LocalDate date1 = LocalDate.of(2019, 12, 11);
        LocalDate date2 = LocalDate.of(2019, 12, 12);

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

        tasks.add(task1);

        doReturn(task1).when(taskerDao).createTask(task2);
        doReturn(task1).when(taskerDao).getTask(5);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory("category");

    }

    public void setUpAdserverClientMock() {

        client = mock(AdServiceClient.class);
        doReturn("random Ad").when(client).getAd();

    }

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpAdserverClientMock();

        serviceLayer = new TaskerServiceLayer();

    }

    @Test
    public void fetchAllTasks() {
        Task task1 = new Task();

        task1.setDescription("description");
        task1.setCreateDate(LocalDate.of(2019, 12, 11));
        task1.setDueDate(LocalDate.of(2019, 12, 12));
        task1.setCategory("category");
        task1 = taskerDao.createTask(task1);

        assertEquals(1, taskerDao.getAllTasks().size());
    }


    @Test
    public void fetchTasksByCategory() {

        LocalDate date1 = LocalDate.of(2019, 12, 11);
        LocalDate date2 = LocalDate.of(2019, 12, 12);

        List<Task> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("category");
        taskerDao.createTask(task1);
        tasks.add(task1);

        Task task2 = new Task();
        task2.setDescription("description");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("category");
        taskerDao.createTask(task2);
        tasks.add(task2);

        assertEquals(2, tasks.size());
    }

    @Test
    public void addGetTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 11);
        LocalDate date2 = LocalDate.of(2019, 12, 12);

        Task task1 = new Task();
        task1.setId(5);
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        taskerDao.createTask(task1);

        taskerDao.getTask(5);

        assertEquals(5, task1.getId());
    }

    @Test
    public void deleteTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 11);
        LocalDate date2 = LocalDate.of(2019, 12, 12);

        Task task1 = new Task();
        task1.setId(5);
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(taskerDao).deleteTask(captor.capture());

        taskerDao.deleteTask(task1.getId());

        verify(taskerDao, times(1)).deleteTask(captor.getValue());

        assertEquals((Integer)5, captor.getValue());

    }

    @Test
    public void updateTask() {

        LocalDate date1 = LocalDate.of(2019, 12, 11);
        LocalDate date2 = LocalDate.of(2019, 12, 12);
        Task task1 = new Task();
        task1.setDescription("description");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("category");

        taskerDao.createTask(task1);

        task1.setDescription("description2");

        taskerDao.updateTask(task1);

        verify(taskerDao).updateTask(any(Task.class));
    }



}