package service;

import enumClasses.TaskStatus;
import model.Task;
import state.TaskState;
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
    void listByStatusCriteria(TaskStatus iterationCriteria);
    void editDescription(int taskId, String description);
    void editStatus(int taskId, TaskState taskState);
    void undoEdit(int taskId);
    void save(int taskId, String description);
}
