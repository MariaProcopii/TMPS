package org.example;

import service.ManageTask;
import service.TaskManager;

public class Main {
    public static void main(String[] args) {
        ManageTask taskManager = TaskManager.getInstance();
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI(taskManager);
        taskManagerCLI.start();
    }
}