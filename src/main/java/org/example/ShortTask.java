package org.example;

import java.util.Date;

public class ShortTask implements Task {
    protected static int countID = 1;
    protected int taskId;
    protected String description;
    protected User assignee;

    public ShortTask(){
        taskId = countID++;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "\n=======ShortTask=======\n" +
                "[taskId]: " + taskId + "\n" +
                "[description]: " + description + "\n" +
                "[assignee]: " + assignee;
    }
}
