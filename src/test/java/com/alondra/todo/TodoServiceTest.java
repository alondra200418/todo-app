package com.alondra.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    @Test
    void testAddTask() {
        TodoService service = new TodoService();
        service.addTask("Study DevOps");

        assertEquals(1, service.getTaskCount());
    }

    @Test
    void testGetTasks() {
        TodoService service = new TodoService();
        service.addTask("Study Jenkins");

        assertTrue(service.getTasks().contains("Study Jenkins"));
    }
}