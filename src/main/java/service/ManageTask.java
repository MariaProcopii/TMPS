package service;

import model.Task;
import styleTask.StyleTaskStrategy;

public interface ManageTask {
    void setStrategy(StyleTaskStrategy strategy);
    void addTask(Task task);
    void listTask();
    Task getTaskById(int taskId);
    void styleTask(Task task, String argument);
    void deleteTask(int taskId);
}
