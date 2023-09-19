package service;

import model.Task;
import styleTask.StyleTaskStrategy;
import java.util.ArrayList;
import java.util.List;

public class TaskManager implements ManageTask {
    private static TaskManager instance;
    private List<Task> tasks = new ArrayList<>();
    private StyleTaskStrategy strategy;

    private TaskManager() {
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void setStrategy(StyleTaskStrategy strategy) {
        this.strategy = strategy;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTask() {
        tasks.forEach(System.out::println);
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void styleTask(Task task, String argument) {
        strategy.applyStyle(task, argument);
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getTaskId() == taskId);
    }
}
