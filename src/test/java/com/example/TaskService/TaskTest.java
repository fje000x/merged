package com.example.TaskService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Task Name", "Task Description");
        assertEquals("1", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "123456789012345678901", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task Name", "123456789012345678901234567890123456789012345678901"));
    }
}
