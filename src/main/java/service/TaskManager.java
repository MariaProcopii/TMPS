package service;

import model.Task;
import styleTask.StyleTaskStrategy;

import java.util.*;

public class TaskManager implements ManageTask{
    private ArrayList<Task> tasks = new ArrayList<>();
    private StyleTaskStrategy strategy;

    public void setStrategy(StyleTaskStrategy strategy) {
        this.strategy = strategy;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTask(){
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

    public void styleTask(Task task, String argument){
        strategy.applyStyle(task, argument);
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getTaskId() == taskId);
    }
}
