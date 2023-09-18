package org.example;

public interface Task {
    public int getTaskId();

    public String getDescription();

    public void setDescription(String description);

    public User getAssignee();

    public void setAssignee(User assignee);
}
