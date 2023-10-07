package state;

import enumClasses.ColorOptions;
import enumClasses.TaskStatus;
import model.LongTask;

public class TaskTodoState implements TaskState{
    public final TaskStatus taskStatus = TaskStatus.TODO;
    @Override
    public void styleTheState(LongTask task) {
        String title = task.getTitle();
        if(title.charAt(1) == '['){
            title = title.substring(4);
        }
        task.setTitle(ColorOptions.RED + title + "\u001B[0m");
    }

    @Override
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
