package com.example.TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        service.addTask(task);
        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        service.addTask(task);
        service.deleteTask("1");
        assertNull(service.getTask("1"));
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task Name", "Task Description");
        service.addTask(task);
        service.updateTask("1", "New Task Name", "New Task Description");
        assertEquals("New Task Name", task.getName());
        assertEquals("New Task Description", task.getDescription());
    }
}
