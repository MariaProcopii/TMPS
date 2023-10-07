package state;

import enumClasses.TaskStatus;
import model.LongTask;

public interface TaskState {
    void styleTheState(LongTask task);
    TaskStatus getTaskStatus();
}
