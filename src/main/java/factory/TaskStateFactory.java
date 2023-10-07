package factory;

import state.TaskCompletedState;
import state.TaskInProgressState;
import state.TaskState;
import state.TaskTodoState;

public class TaskStateFactory {
    TaskState taskState;
    public TaskState getTaskState(String status){
        switch (status){
            case "TODO":
                taskState = new TaskTodoState();
                break;
            case "IN_PROGRESS":
                taskState = new TaskInProgressState();
                break;
            case "COMPLETED":
                taskState = new TaskCompletedState();
                break;
            default: throw  new IllegalArgumentException("Unknown option " + status);
        }
        return taskState;
    }
}
