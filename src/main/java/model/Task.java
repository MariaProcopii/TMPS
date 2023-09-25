package model;

public interface Task {
    int getTaskId();
    String getDescription();
    void setDescription(String description);
    void setAssignee(User assignee);
    void listTask();
}
