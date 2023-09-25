package service;

import model.Task;
import styleTask.StyleTaskStrategy;

import java.util.ArrayList;

public interface TaskManager {
    void setStrategy(StyleTaskStrategy strategy);
    void addTask(Task task);
    Task getTaskById(int taskId);
    ArrayList<Task> getAllTasks();
    void listTask();
    void styleTask(Task task, String argument);
    void styleAllTasks(String argument);
    void deleteTask(int taskId);

    void deleteAllTasks();
}
