package com.alondra.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private List<String> todos = new ArrayList<>();

    public void addTask(String task) {
        todos.add(task);
    }

    public List<String> getTasks() {
        return todos;
    }

    public int getTaskCount() {
        return todos.size();
    }
}