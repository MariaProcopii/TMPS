package org.example;
import Decorator.AdminInfoUserDecorator;
import Decorator.AdminUserDecorator;
import model.RegularUser;
import model.User;
import service.TaskManager;
import service.TaskManagerProxy;
import styleTask.TextColorChanger;

public class Main {
    public static void main(String[] args) {
        User user = new RegularUser("Mary");

        user = new AdminUserDecorator(new AdminInfoUserDecorator(user));

        TaskManager taskManager = new TaskManagerProxy(user.isAdmin());
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI(taskManager, user);
        taskManagerCLI.start();
        System.out.println(TextColorChanger.n);
    }
}