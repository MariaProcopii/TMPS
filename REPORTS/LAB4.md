# Topic: *Behavioral Design Patterns*
## Author: *Proccopii Maria*
------
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

   * Chain of Responsibility
   * Command
   * Interpreter
   * Iterator
   * Mediator
   * Observer
   * Strategy

## Implementation:
*Iterator design pattern*

The Iterator Design Pattern is a behavioral design pattern that provides a way to access elements of an aggregate (a collection of objects) 
sequentially without exposing the underlying representation of the collection. It is used to separate the traversal logic from the data structure,
making it easier to work with different types of collections and iterate through them in a consistent manner.

In my project I created `TaskIteratorImplementation` class which provides an iterator mechanism for a list of tasks, allowing to iterate over them 
while filtering based on a specific `TaskStatus` criterion. It ensures that only tasks matching the criterion are returned when method `next()` is called.

```java
@Override
public boolean hasNext() {
        while (position < tasks.size()){
            Task task = tasks.get(position);
            if(task.getStatus().getTaskStatus() == iterationCriteria){
                return true;
            }
            else {
                position++;
            }
        }
        return false;
}

@Override
public Task next() {
    return tasks.get(position++);
}
```

*Strategy design pattern*

The Strategy Design Pattern is a behavioral design pattern that defines a family of interchangeable algorithms or behaviors and allows them to be used 
interchangeably within a context without altering the client code. It encapsulates each of these algorithms into separate classes, making it easy to switch 
between them at runtime. The Strategy pattern promotes flexibility, maintainability, and the ability to adapt to changing requirements.

In my project I have a `StyleTaskStrategy` interfaces with a single method `applyStyle()`. The core idea behind the Strategy Design Pattern in this context is to encapsulate
different text styling or formatting behaviors into separate classes (concrete strategies), `BackgroundColorChanger`, `TextColorChanger` and `TextFormatChanger`. These classes
can be easily switched and applied to a Task object without modifying the Task class itself.

For example, if you want to change the text color of a task's description, you can create an instance of `TextColorChanger` and call its `applyStyle` method. 
Similarly, if you want to apply a different style, such as bold or italic, you can use the `TextFormatChanger` class. I create a needed instance in a factory 
`StyleTaskFactory ` and use it in `pickStyleMethod()` of `TaskManagerCLI` class.

```java
public class TextColorChanger implements StyleTaskStrategy {
  public static int n = 0;
  public TextColorChanger() {
      n++;
  }

  @Override
  public void applyStyle(Task task, String arg) {
      ColorOptions colorCode = getColorCode(arg);
      String description = task.getDescription();
      if(description.charAt(1) == '['){
          description = task.getDescription().substring(4);
      }
      task.setDescription(colorCode + description + "\u001B[0m");
  }
...
}
```

*Memento design pattern*

The Memento Design Pattern is a behavioral design pattern that provides a way to capture and externalize an object's internal state so that the object can
be restored to that state later. This pattern is useful when you need to implement features like undo/redo functionality, checkpointing, or preserving the
state of an object for historical or recovery purposes.

I have a special interface `Memento` which describes which methods should be implemented by a memento class. `TaskDescriptionMemento` is used to create a backup 
history for the changes description of the `Task` class. When the task is created, I save the record about its description in a memento class.
`TaskManagerImplement` class has the `edit()` method which allow to edit the created task, `save()` to save the changes to history and `undoEdit()` to undo the changes 
back t last saved description. The user is able to undo the changes multiple times, back to the first copy when the `Task` object was created.

```java
package memento;

public class TaskDescriptionMemento implements Memento{
    private final int id;
    private final String content;
    public TaskDescriptionMemento(int id, String description) {
        this.id = id;
        this.content = description;
    }

    public String getContent(){
        return content;
    }

    public int getId(){
        return id;
    }
}
```

*State design pattern*

The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. It is used to model 
the behavior of an object as a finite set of states, and the object's actions and transitions between states are explicitly defined. This pattern helps in
managing state-specific behavior cleanly and without the need for large conditional statements.

I use this pattern to change the color of test field in a `Task` class depending on status field. I have 3 states: `TaskCompletedState`, `TaskTodoState` and `TaskInProgressState`. 
State Design Pattern is useful for managing the behavior of objects that transition between different states. It promotes clean, maintainable code by separating state-specific
behavior into distinct classes and provides a structured way to handle state transitions and state-specific actions.

```java
public class TaskInProgressState implements TaskState{
    public final TaskStatus taskStatus = TaskStatus.IN_PROGRESS;
    @Override
    public void styleTheState(LongTask task) {
        String title = task.getTitle();
        if(title.charAt(1) == '['){
            title = title.substring(4);
        }
        task.setTitle(ColorOptions.YELLOW + title + "\u001B[0m");
    }

    @Override
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
}
```

## Conclusion:
Structural design patterns are an essential aspect of software design that focus on the composition and organization of classes and objects to build flexible 
and maintainable systems. They provide solutions to common structural problems and challenges in software development. 

However, it's crucial to note that not all structural patterns are suitable for every situation. Developers should carefully evaluate the specific needs of their 
project before choosing and applying a structural pattern. Overuse or misuse of patterns can lead to overly complex code and unnecessary abstraction.

In conclusion, structural design patterns are a valuable resource for software developers, helping them create well-structured, maintainable, and flexible software systems.
By understanding and applying these patterns appropriately, developers can build software that is easier to develop, understand, and maintain, ultimately leading to more robust
and efficient applications.





