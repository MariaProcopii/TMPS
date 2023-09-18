# Creational Design Patterns


## Author: Procopii Maria

----

## Objectives:

* Get familiar with the Design Pattern;
* Choose a specific domain;
* Implement at least 2 CDPs for the specific domain;


## Used Design Patterns:

### Single Responsibility Principle (SRP):

This principle states that a class should have only one reason to change, 
meaning it should have only one responsibility or job.

### Open/Closed Principle (OCP):

The Open/Closed Principle states that software entities (e.g., classes, modules) should be open for extension but closed for modification.
This means you should be able to add new functionality to a system without altering existing code.

### Liskov Substitution Principle (LSP):

The Liskov Substitution Principle states that objects of a derived class should be able to replace objects 
of the base class without affecting the correctness of the program.

### Interface Segregation Principle (ISP):

This principle suggests that clients should not be forced to depend on interfaces they do not use.

### Dependency Inversion Principle (DIP):

The Dependency Inversion Principle emphasizes high-level modules (e.g., abstractions) should not depend on low-level modules (e.g., concrete implementations). 
Both should depend on abstractions.

## Implementation:

My project is about task management system. `TaskManager` is responsible for task manipulation ( create, search, delete, modify ), depositing all the task created by user
( like a DB ) and `TaskManagerCLI` uses it to create the visualization. 
Every class have only one job and this follows the `SRP`. We are able to create two kinds of task
`ShortTask` and an extended version of it - `LongTask`. Here I follow the `OCP` and `LSP`- because derived class can replace objects of the base class without 
affecting the correctness of the program. Presence of `ISP` is visible because every interface is small and responsible for one thing. `Task` is a contract which describes
what should implement a task based class and `StyleTaskStrategy` which is used to create a group of classes responsible for changing the test style.
The last principle `DIP` can be noticed in `TaskManager` class. I inject the needed style strategy class by passing not the concrete class but the interface which creates 
the group of related classes. Because of that we can use different strategy classes if needed.
User are able to change the text in 3 ways: [ text color, background color, text format ]. Color in terminal is change by usage of ANSI escape codes ( can be visualized in enum class like `ColorOptions` ). For these actions are responsible 
3 different classes `BackgroundColorChanger`, `TextColorChanger` and `TextFormatChanger`. All of them implements `StyleTaskStrategy` and can be used in `TaskManager` injected by a setter
in `TaskManagerCLI`.

* Example of DIP
```java
public class TaskManagerCLI {
    private TaskManager taskManager;
    ...

    private void pickStyleMethod() {
        ...
        taskManager.setStrategy(strategy);
        ...
    }
}

public class TaskManager {
    private StyleTaskStrategy strategy;
    ...
    public void styleTask(Task task, String argument){
        strategy.applyStyle(task, argument);
    }
}
```

* Enum class with ANSI escape codes and usage of it in `TextColorChanger`
```java
public enum ColorOptions {

    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    ...

    private final String code;

    ColorOptions(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}

public class TextColorChanger implements StyleTaskStrategy {

    @Override
    public void applyStyle(Task task, String arg) {
        ColorOptions colorCode = getColorCode(arg);
        task.setDescription(colorCode + task.getDescription());
    }

    private ColorOptions getColorCode(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "black" -> ColorOptions.BLACK;
            case "red" -> ColorOptions.RED;
            case "green" -> ColorOptions.GREEN;
            ...
        };
    }
}
```


## Results:
```java
-------------Task Manager CLI-------------

[1]. Add Long Task
[2]. Add Short Task
[3]. List Task by ID
[4]. List All Tasks
[5]. Change Task Style
[6]. Delete LongTask
[7]. Exit

Select an option: 1

=======Add Long Task=======

Enter description (mandatory): Laborator nr 2 at cryptography.
Enter title (optional): Lab 2 CS
Enter due date (yyyy-MM-dd, optional): 2023-09-22
Enter task status [TODO, IN_PROGRESS, COMPLETED, ON_HOLD, optional]: TODO
Enter assignee (optional): 
Task added successfully.

-------------------
        Select an option: 3

        =======Task by ID=======

        Enter task ID: 1
        LongTask found:

        =======LongTask=======
        [taskId]: 1
        [title]: Lab 2 CS
        [description]: Laborator nr 2 at cryptography.
        [dueDate]: Fri Sep 22 00:00:00 EEST 2023
        [status]: TODO
        [assignee]: null
        
----------------------
        Select an option: 5

        =======Style Task=======

        Enter task ID: 1
        Enter Style method: [ text color, background color, text format ]
<- Return Back: [B/b]
        text color
        Pick color: [ black, green, yellow, peach, magenta, cyan, white ]
        green
        Enter Style method: [ text color, background color, text format ]
<- Return Back: [B/b]
        text format
        Pick text format: [ bold, italic, underline ]
        bold
        Enter Style method: [ text color, background color, text format ]
<- Return Back: [B/b]
        b

-----------------------
![img.png](img.png)

```

## Conclusion:
By following these SOLID principles, we can create code that is easier to understand, 
maintain, and extend. These principles contribute to the development of robust and 
flexible software systems that are less prone to bugs and easier to adapt to changing requirements.