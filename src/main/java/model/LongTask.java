package model;

import builder.LongTaskBuilder;
import enumClasses.TaskStatus;
import state.TaskState;

import java.util.Date;
public class LongTask extends ShortTask {
    private String title;
    private Date dueDate;


    public LongTask(LongTaskBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.status = builder.status;
        this.assignee = builder.assignee;
        styleText();
    }

    public void styleText(){
        if(title != null && status != null) {
            status.styleTheState(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskState getStatus() {
        return status;
    }

    public void listTask() {
        System.out.println("\n=======LongTask=======\n" +
                "[taskId]: " + taskId + "\n" +
                "[title]: " + title + "\n" +
                "[description]: " + description + "\n" +
                "[dueDate]: " + dueDate + "\n" +
                "[status]: " + (status == null ? "null": status.getTaskStatus()) + "\n" +
                "[assignee]: " + assignee);
    }
}
