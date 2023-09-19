package org.example;

import service.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI(taskManager);
        taskManagerCLI.start();
    }
}