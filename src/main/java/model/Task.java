package model;

import state.TaskState;

public interface Task {
    int getTaskId();
    String getDescription();
    void setDescription(String description);
    void setAssignee(User assignee);
    void listTask();
    User getUser();

    TaskState getStatus();
    void setStatus(TaskState status);
}
