package iterator;

import enumClasses.TaskStatus;
import model.Task;

import java.util.ArrayList;

public class TaskIteratorImplementation implements TaskIterator{
    private ArrayList<Task> tasks;
    TaskStatus iterationCriteria;
    private int position;

    public TaskIteratorImplementation(TaskStatus iterationCriteria, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.iterationCriteria = iterationCriteria;
    }

    @Override
    public boolean hasNext() {
            while (position < tasks.size()){
                Task task = tasks.get(position);
                if(task.getStatus().getTaskStatus() == iterationCriteria){
                    return true;
                }
                else {
                    position++;
                }
            }
            return false;
    }

    @Override
    public Task next() {
        return tasks.get(position++);
    }
}
