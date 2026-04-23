package com.alondra.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // This tells Spring to load the context for the test
class TodoServiceTest {

    @Autowired
    private TodoService service; // Inject the service instead of calling 'new'

    @Test
    void testAddTask() {
        // We might want to clear tasks or check current count to ensure a clean test
        int initialCount = service.getTaskCount();
        service.addTask("Study DevOps");

        assertEquals(initialCount + 1, service.getTaskCount());
    }

    @Test
    void testGetTasks() {
        service.addTask("Study Jenkins");
        assertTrue(service.getTasks().contains("Study Jenkins"));
    }
}