# Topic: *Creational Design Patterns*
## Author: *Procopii Maria*
------
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Some examples of this kind of design patterns are:

   * Singleton
   * Builder
   * Prototype
   * Object Pooling
   * Factory Method
   * Abstract Factory

## Implementation:
*Builder Design Pattern*
I my project builder is represented by class `LomgTaskBuilder` which is used to create a new instance of `LongTask`
objects with various attributes. The builder class has public fields for attributes like title, description, dueDate, status, and assignee.
The builder class has a constructor that takes a mandatory parameter description. This parameter ensures that every task must have a description.
The builder class provides setter methods for each optional attribute (e.g., title, dueDate, status, assignee). 
These methods allow you to set
individual attribute values and return the builder instance (this) to enable method chaining. 
Method chaining makes it easy to set multiple attributes in a single statement.
The `build()` method is used to construct a LongTask object. It creates a new LongTask instance by passing the current LongTaskBuilder 
instance (this) as a parameter to the LongTask constructor. This allows the LongTask constructor to access and use the values set in the builder.

*Usage Example:*

```java
LongTask task = new LongTaskBuilder("Task Description")
    .title("Task Title")
    .dueDate(new Date())
    .status(TaskStatus.IN_PROGRESS)
    .assignee(user)
    .build();
```

*Factory Design Pattern*
The Factory design pattern is employed in my code through the `StyleTaskFactory` class. This pattern offers a structured approach for creating
objects without specifying their concrete classes. In my case, the `StyleTaskFactory` acts as a factory to produce instances of `StyleTaskStrategy`
objects, each representing a different strategy for applying styles to tasks.

The heart of the factory pattern lies in the `getStyleStrategy(String option)` method. This factory method accepts an option as input,
which indicates the desired style strategy to create. If the option is null or empty, it returns null. Otherwise, it utilizes a switch 
statement to determine the appropriate StyleTaskStrategy type based on the provided option, and then it instantiates and returns an 
instance of that strategy.

*Usage Example:*

```java
  System.out.println("Enter Style method: [ text color, background color, text format ]");
  System.out.println("<- Return Back: [B/b]");

  option = scanner.nextLine().toLowerCase();
  if(option.equals("b")){
      back = true;
  }
  else {
      StyleTaskFactory styleTaskFactory = new StyleTaskFactory();
      StyleTaskStrategy strategy = styleTaskFactory.getStyleStrategy(option);
```

*Singleton Design Pattern*
`TaskManager` class represents a manager for tasks and follows the Singleton design pattern. It ensures that only one instance of the `TaskManager`
class can exist throughout the application's lifetime. The `TaskManager` constructor is private, preventing external classes from creating new instances 
of TaskManager. The `getInstance()` method provides a way to access the single instance of TaskManager. If no instance exists, it creates one, 
otherwise, it returns the existing instance. This ensures that there is only one TaskManager instance in my application. I need to ensure that only one
instance is created because this class contains the list of all created tasks with which we work.

*Usage Example:*

```java
public class Main {
    public static void main(String[] args) {
        ManageTask taskManager = TaskManager.getInstance();
        TaskManagerCLI taskManagerCLI = new TaskManagerCLI(taskManager);
        taskManagerCLI.start();
    }
}
```











