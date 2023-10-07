package model;

import state.TaskState;

public class ShortTask implements Task {
    protected static int countID = 1;
    protected int taskId;
    protected String description;
    protected TaskState status;
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

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public TaskState getStatus() {
        return status;
    }

    public void setStatus(TaskState status) {
        this.status = status;
    }

    @Override
    public void listTask() {
        System.out.println("\n=======ShortTask=======\n" +
                "[taskId]: " + taskId + "\n" +
                "[description]: " + description + "\n" +
                "[status]: " + (status == null ? "null": status.getTaskStatus()) + "\n" +
                "[assignee]: " + assignee);
    }

    @Override
    public User getUser() {
        return assignee;
    }
}
