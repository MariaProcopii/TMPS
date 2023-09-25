package service;

import model.Task;
import styleTask.StyleTaskStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//composite design pattern
//singleton
public class TaskManagerImplement implements TaskManager {
    private static TaskManagerImplement instance;
    private ArrayList<Task> tasks = new ArrayList<>();
    private StyleTaskStrategy strategy;

    private TaskManagerImplement() {
    }

    public static TaskManagerImplement getInstance() {
        if (instance == null) {
            instance = new TaskManagerImplement();
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
        tasks.forEach(Task::listTask);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
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

    public void styleAllTasks(String argument) {
        tasks.forEach(task -> strategy.applyStyle(task, argument));
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getTaskId() == taskId);
    }

    public void deleteAllTasks(){
        tasks.clear();
    }
}
