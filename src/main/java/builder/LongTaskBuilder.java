package builder;

import model.LongTask;
import enumClasses.TaskStatus;
import model.RegularUser;
import model.User;

import java.util.Date;

public class LongTaskBuilder {
    public String title;
    public String description;
    public Date dueDate;
    public TaskStatus status;
    public User assignee;

    public LongTaskBuilder(String description) {
        this.description = description;
    }

    public LongTaskBuilder title(String title) {
        this.title = title;
        return this;
    }

    public LongTaskBuilder dueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LongTaskBuilder status(TaskStatus status) {
        this.status = status;
        return this;
    }

    public LongTaskBuilder assignee(User assignee) {
        this.assignee = assignee;
        return this;
    }

    public LongTask build() {
        return new LongTask(this);
    }
}
