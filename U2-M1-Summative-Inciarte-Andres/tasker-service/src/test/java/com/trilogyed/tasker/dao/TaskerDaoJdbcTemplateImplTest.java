package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    private Task task, task2;

    @Before
    public void setUp() throws Exception {
        taskerDao.getAllTasks().forEach(task -> {
            taskerDao.deleteTask(task.getId());
        });

        task = new Task();
        task.setCategory("category");
        task.setCreateDate(LocalDate.of(2019,1, 22));
        task.setDescription("Description");
        task.setDueDate(LocalDate.of(2020,1,22));

        task2 = new Task();
        task2.setCategory("category2");
        task2.setCreateDate(LocalDate.of(2019,1, 11));
        task2.setDescription("Description2");
        task2.setDueDate(LocalDate.of(2020,1,11));

    }

    @Test
    public void createTask() {

        task = taskerDao.createTask(task);

        assertEquals(1,taskerDao.getAllTasks().size());

    }

    @Test
    public void getTask() {

        task = taskerDao.createTask(task);

        Task getTask = taskerDao.getTask(task.getId());

        assertEquals(getTask, task);

    }

    @Test
    public void getAllTasks() {

        task = taskerDao.createTask(task);
        task2 = taskerDao.createTask(task2);

        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(2, taskList.size());
    }

    @Test
    public void getTasksByCategory() {

        task = taskerDao.createTask(task);
        task2 = taskerDao.createTask(task2);

        List<Task> tasksByCategory = taskerDao.getTasksByCategory("category");

        assertEquals(1, tasksByCategory.size());

    }

    @Test
    public void updateTask() {

        task = taskerDao.createTask(task);
        task.setDescription("new Description");

        taskerDao.updateTask(task);

        Task updatedTask = taskerDao.getTask(task.getId());

        assertEquals(task,updatedTask);

    }

    @Test
    public void deleteTask() {

        task = taskerDao.createTask(task);

        taskerDao.deleteTask(task.getId());

        Task deletedTask = taskerDao.getTask(task.getId());

        assertNull(deletedTask);

    }
}