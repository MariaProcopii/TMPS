package service;
import enumClasses.ColorOptions;
import enumClasses.TaskStatus;
import model.Task;
import state.TaskState;
import styleTask.StyleTaskStrategy;

import java.util.ArrayList;

public class TaskManagerProxy implements TaskManager {
    private TaskManager realTaskManager = TaskManagerImplement.getInstance();
        private boolean isAdmin;

    public TaskManagerProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void setStrategy(StyleTaskStrategy strategy) {
        realTaskManager.setStrategy(strategy);
    }

    @Override
    public void addTask(Task task) {
            realTaskManager.addTask(task);
    }

    @Override
    public void listTask() {
        realTaskManager.listTask();
    }

    @Override
    public ArrayList<Task> getAllTasks() {
        if (isAdmin) {
            return realTaskManager.getAllTasks();
        } else {
            System.out.println(ColorOptions.RED +
                    "\n=====Only admins can get tasks.=====\n" +
                    ColorOptions.RESET);
            return null;
        }
    }

    @Override
    public Task getTaskById(int taskId) {
        return realTaskManager.getTaskById(taskId);
    }

    @Override
    public void styleTask(Task task, String argument) {
        if (isAdmin) {
            realTaskManager.styleTask(task, argument);
        } else {
            System.out.println(ColorOptions.RED +
                    "\n=====Only admins can style tasks.=====\n" +
                    ColorOptions.RESET);
        }
    }

    @Override
    public void styleAllTasks(String argument) {
        if (isAdmin) {
            realTaskManager.styleAllTasks(argument);
        } else {
            System.out.println(ColorOptions.RED +
                    "\n=====Only admins can style tasks.=====\n" +
                    ColorOptions.RESET);
        }
    }

    @Override
    public void deleteTask(int taskId) {
        if (isAdmin) {
            realTaskManager.deleteTask(taskId);
        } else {
            System.out.println(ColorOptions.RED +
                    "\n=====Only admins can delete tasks.=====" +
                    ColorOptions.RESET);
        }
    }

    @Override
    public void deleteAllTasks() {
        if (isAdmin) {
            realTaskManager.deleteAllTasks();
        } else {
            System.out.println(ColorOptions.RED +
                    "\n=====Only admins can delete tasks.=====" +
                    ColorOptions.RESET);
        }
    }

    @Override
    public void listByStatusCriteria(TaskStatus iterationCriteria) {
        realTaskManager.listByStatusCriteria(iterationCriteria);
    }

    @Override
    public void editDescription(int taskId, String description) {
        realTaskManager.editDescription(taskId, description);
    }

    @Override
    public void editStatus(int taskId, TaskState taskState) {
        realTaskManager.editStatus(taskId, taskState);
    }

    @Override
    public void undoEdit(int taskId) {
        realTaskManager.undoEdit(taskId);
    }

    @Override
    public void save(int taskId, String description) {
        realTaskManager.save(taskId, description);
    }
}

