package model;

import builder.LongTaskBuilder;
import enumClasses.TaskStatus;

import java.util.Date;
public class LongTask extends ShortTask {
    private String title;
    private Date dueDate;
    private TaskStatus status;

    public LongTask(LongTaskBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.status = builder.status;
        this.assignee = builder.assignee;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n=======LongTask=======\n" +
                "[taskId]: " + taskId + "\n" +
                "[title]: " + title + "\n" +
                "[description]: " + description + "\n" +
                "[dueDate]: " + dueDate + "\n" +
                "[status]: " + status + "\n" +
                "[assignee]: " + assignee;
    }
}
