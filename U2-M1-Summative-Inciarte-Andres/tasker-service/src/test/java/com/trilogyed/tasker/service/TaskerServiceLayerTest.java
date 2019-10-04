//package com.trilogyed.tasker.service;
//
//import com.trilogyed.tasker.dao.TaskerDao;
//import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
//import com.trilogyed.tasker.model.Task;
//import com.trilogyed.tasker.model.TaskViewModel;
//import com.trilogyed.tasker.util.feign.AdServiceClient;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TaskerServiceLayerTest {
//
//    TaskerServiceLayer serviceLayer;
//
//    TaskerDao taskerDao;
//
//    AdServiceClient client;
//
//    public void setUpTaskerDaoMock() {
//
//        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//
//        List<Task> tasks = new ArrayList<>();
//
//        Task task1 = new Task();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);
//        task1.setDueDate(date2);
//        task1.setCategory("category");
//
//        Task task2 = new Task();
//        task2.setId(5);
//        task2.setDescription("description");
//        task2.setCreateDate(date1);
//        task2.setDueDate(date2);
//        task2.setCategory("category");
//        tasks.add(task2);
//
//        Task task3 = new Task();
//        task3.setDescription("Trim Hedges.");
//        task3.setCreateDate(date1);
//        task3.setDueDate(date2);
//        task3.setCategory("category");
//
//        Task task4 = new Task();
//        task4.setId(8);
//        task4.setDescription("Trim Hedges.");
//        task4.setCreateDate(date1);
//        task4.setDueDate(date2);
//        task4.setCategory("category");
//        tasks.add(task4);
//
//        doReturn(task2).when(taskerDao).createTask(task1);
//        doReturn(task4).when(taskerDao).createTask(task3);
//        doReturn(task2).when(taskerDao).getTask(5);
//        doReturn(tasks).when(taskerDao).getAllTasks();
//        doReturn(tasks).when(taskerDao).getTasksByCategory("category");
//
//    }
//
//    public void setUpAdserverClientMock() {
//
//        client = mock(AdServiceClient.class);
//        doReturn("Random Ad").when(client).getAd();
//
//    }
//
//    @Before
//    public void setUp() throws Exception {
//
//        setUpTaskerDaoMock();
//        setUpAdserverClientMock();
//
//        serviceLayer = new TaskerServiceLayer();
//
//    }
//
//    @Test
//    public void fetchAllTasks() {
//
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//
//        List<TaskViewModel> tasks = new ArrayList<>();
//
//        TaskViewModel task1 = new TaskViewModel();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);
//        task1.setDueDate(date2);
//        task1.setCategory("category");
//        task1 = serviceLayer.newTask(task1);
//        tasks.add(task1);
//
//        TaskViewModel task2 = new TaskViewModel();
//        task2.setDescription("Trim Hedges.");
//        task2.setCreateDate(date1);
//        task2.setDueDate(date2);
//        task2.setCategory("category");
//        task2 = serviceLayer.newTask(task2);
//        tasks.add(task2);
//
//        List<TaskViewModel> tasks2 = serviceLayer.fetchAllTasks();
//
//        assertEquals(2, tasks2.size());
//
//    }
//
//    @Test
//    public void fetchTasksByCategory() {
//
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//
//        List<TaskViewModel> tasks = new ArrayList<>();
//
//        TaskViewModel task1 = new TaskViewModel();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);
//        task1.setDueDate(date2);
//        task1.setCategory("category");
//        task1 = serviceLayer.newTask(task1);
//        tasks.add(task1);
//
//        TaskViewModel task2 = new TaskViewModel();
//        task2.setDescription("Trim Hedges.");
//        task2.setCreateDate(date1);
//        task2.setDueDate(date2);
//        task2.setCategory("category");
//        task2 = serviceLayer.newTask(task2);
//        tasks.add(task2);
//
//        List<TaskViewModel> tasks2 = serviceLayer.fetchTasksByCategory("category");
//
//        assertEquals(2, tasks2.size());
//    }
//
//    @Test
//    public void addGetTask() {
//
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//        TaskViewModel task1 = new TaskViewModel();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
//        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
//        task1.setCategory("category");
//
//        task1 = serviceLayer.newTask(task1);
//
//        TaskViewModel task2 = serviceLayer.fetchTask(5);
//
//        assertEquals(task1.toString(), task2.toString());
//    }
//
//    @Test
//    public void deleteTask() {
//
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//        TaskViewModel task1 = new TaskViewModel();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
//        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
//        task1.setCategory("category");
//
//        task1 = serviceLayer.newTask(task1);
//
//        taskerDao.deleteTask(task1.getId());
//
//        verify(taskerDao).deleteTask(any(Integer.class));
//
//    }
//
//    @Test
//    public void updateTask() {
//
//        LocalDate date1 = LocalDate.of(2019, 12, 21);
//        LocalDate date2 = LocalDate.of(2020, 12, 21);
//        TaskViewModel task1 = new TaskViewModel();
//        task1.setDescription("description");
//        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
//        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
//        task1.setCategory("category");
//
//        task1 = serviceLayer.newTask(task1);
//
//        task1.setDescription("description2");
//
//        serviceLayer.updateTask(task1);
//
//        verify(taskerDao).updateTask(any(Task.class));
//    }
//
//
//
//}