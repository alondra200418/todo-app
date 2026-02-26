package com.alondra.todo;

public class Main {
    public static void main(String[] args) {
        TodoService service = new TodoService();
        service.addTask("Finish DevOps Project");

        System.out.println("Task count: " + service.getTaskCount());
        System.out.println("Tasks: " + service.getTasks());
        System.out.println("Demo build test!");
    }
}