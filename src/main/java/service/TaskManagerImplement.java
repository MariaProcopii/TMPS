package service;

import enumClasses.TaskStatus;
import iterator.TaskIteratorImplementation;
import memento.Memento;
import memento.TaskDescriptionMemento;
import model.LongTask;
import model.Task;
import state.TaskState;
import styleTask.StyleTaskStrategy;
import java.util.ArrayList;

//composite design pattern
//singleton
//memento
public class TaskManagerImplement implements TaskManager {
    private static TaskManager instance;
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Memento> history = new ArrayList<>();
    private StyleTaskStrategy strategy;

    private TaskManagerImplement() {
    }

    public static TaskManager getInstance() {
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
        history.add(new TaskDescriptionMemento(task.getTaskId(), task.getDescription()));
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

    public void listByStatusCriteria(TaskStatus iterationCriteria){
        TaskIteratorImplementation iterator = new TaskIteratorImplementation(iterationCriteria, tasks);
        while (iterator.hasNext()){
            iterator.next().listTask();
        }
    }

    public void editDescription(int taskId, String description){
        Task task = getTaskById(taskId);
        if(task == null){
            System.out.println("Task not found.");
        }
        else {
            task.setDescription(description);
        }
    }

    public void editStatus(int taskId, TaskState taskState){
        LongTask task = null;
        if(getTaskById(taskId) instanceof LongTask){
            task = (LongTask) getTaskById(taskId);
        }
        if(task == null){
            System.out.println("Task not found.");
        }
        else {
            task.setStatus(taskState);
            task.styleText();
        }
    }

    public void save(int taskId, String description){
        history.add(new TaskDescriptionMemento(taskId, description));
    }

    public void undoEdit(int taskId){
        Task task = getTaskById(taskId);
        boolean wasFound = false;
        int index = 0;

        if(!history.isEmpty()){
            for(int i = 0; i < history.size(); i++){
                Memento memento = history.get(i);
                if(memento.getId() == taskId){
                    index = i;
                    wasFound = true;
                    task.setDescription(memento.getContent());
                }
                else{
                    System.out.println("Cannot restore");
                }
            }
            if(wasFound){
                history.remove(index);
            }
        }
    }
}
