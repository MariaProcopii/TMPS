package org.example;

import model.TaskManager;
import model.TaskManagerCLI;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI(taskManager);
        taskManagerCLI.start();
    }
}