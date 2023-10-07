package state;

import enumClasses.ColorOptions;
import enumClasses.TaskStatus;
import model.LongTask;

public class TaskCompletedState implements TaskState{
    public final TaskStatus taskStatus = TaskStatus.COMPLETED;
    @Override
    public void styleTheState(LongTask task) {
        String title = task.getTitle();
        if(title.charAt(1) == '['){
            title = title.substring(4);
        }
        task.setTitle(ColorOptions.GREEN + title + "\u001B[0m");
    }

    @Override
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
