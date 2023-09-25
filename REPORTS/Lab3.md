# Topic: *Structural Design Patterns*
## Author: *Procopii Maria*
------
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that 
your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theory:
&ensp; &ensp; Structural design patterns are a crucial component of software design patterns, a set of recurring solutions 
to common problems in software design. These patterns focus on how classes and objects can be combined to form larger structures 
while keeping the system flexible and efficient. They help in organizing code in a way that promotes reusability, maintainability, 
and scalability.

&ensp; &ensp; Some examples of this kind of design patterns are:

   * Adapter
   * Bridge
   * Composite
   * Decorator
   * Facade
   * Flyweight
   * Proxy

## Implementation:
*Structural Design Pattern*

*Flyweight design pattern*
The Flyweight design pattern is a structural design pattern that focuses on optimizing the use of memory or storage by 
sharing as much as possible among multiple objects. It is used when a system has a large number of similar objects, and 
the goal is to reduce the overall memory usage and improve performance.

In my project I use this pattern in `StyleTaskFactory` class. Instead of creating an instance of `styleTaskStrategy` class every
time user picks a the same strategy, I store them in an ArrayList and take them when needed.

```java
styleTaskStrategy = strategies.get(option.toLowerCase().trim());
if(styleTaskStrategy == null){
    switch (option.toLowerCase()){
        case "text color":
            styleTaskStrategy = new TextColorChanger();
            break;
        case "background color":
            styleTaskStrategy = new BackgroundColorChanger();
            break;
        case "text format":
            styleTaskStrategy = new TextFormatChanger();
            break;
        default: throw  new IllegalArgumentException("Unknown option " + option);
    }
}

strategies.put(option, styleTaskStrategy);
return styleTaskStrategy;
```

*Proxy design pattern*
The Proxy design pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access 
to it. In essence, it acts as an intermediary, allowing you to add an extra level of control over how, when, and where you interact with
an object. The Proxy pattern is particularly useful when you want to control access to an object, add lazy loading, implement access control,
or introduce logging and monitoring without modifying the actual object.

Im my project I use proxy in `TaskManagerCLI` to controll the access to some options of task modification ( like `styleTask()`, `deleteTask()` ... ).
`TaskManagerProxy` uses inside an instance of `TaskManager` class and applies some restricions if the user is not loggen in as an Admin.

```java
public void deleteTask(int taskId) {
    if (isAdmin) {
        realTaskManager.deleteTask(taskId);
    } else {
        System.out.println(ColorOptions.RED +
                "\n=====Only admins can delete tasks.=====" +
                ColorOptions.RESET);
    }
}
```

*Composite design pattern*


The Composite design pattern is a structural design pattern that allows to compose objects into tree structures to represent
part-whole hierarchies. It lets clients treat individual objects and compositions of objects (composites) uniformly. This pattern
is used when you have objects that can be combined into larger structures and you want to treat both individual objects and their 
compositions in a consistent manner.

Composite pattern is present in `TaskManagerImplement` to be able to treat tasks as a whole. Example of usage is `styleAllTasks()`
method which allows me to style not only a particular task but all of them, or `listTask()`. Also I provide some helper methods to add or 
delete leafs from 
the group.

```java
  public void styleAllTasks(String argument) {
      tasks.forEach(task -> strategy.applyStyle(task, argument));
  }

...

  public void deleteAllTasks(){
      tasks.clear();
  }
```

*Decorator Design pattern*

The Decorator design pattern is a structural design pattern that allows you to add behavior or responsibilities to objects dynamically
without altering their code. It is used to extend the functionality of objects in a flexible and open-ended way. This pattern is particularly
useful when you have a class hierarchy with many potential combinations of features, and you want to avoid creating a large number of subclasses
to represent all possible combinations.

In my project I use decorator with `RegularUser` class. With some functionality I need the Admin rights and to dinamycally change it I use 
`AdminUserDecorator` class. Also I can combine it with `AdminInfoUserDecorator` to add additional information in `toString()` method about the time
when user logged in. 

```java
public String toString() {
    return super.toString() + additionalInfo();
}

public String additionalInfo(){

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTime = promotionTime.format(formatter);
    return ", Lon in time='" + formattedTime + '\'';
}
```

## Conclusion:

In conclusion, structural design patterns are invaluable tools in software development for creating well-organized, f
lexible, and efficient systems. These patterns offer solutions to common design challenges, allowing developers to build 
software that is easier to maintain, extend, and understand. By emphasizing principles such as separation of concerns, encapsulation,
and code reusability, structural design patterns help ensure that software remains adaptable and scalable as requirements evolve.

When applying structural design patterns, it's essential to carefully analyze the specific problem at hand and choose the most appropriate 
pattern. Overusing patterns can lead to unnecessary complexity, so a judicious approach is necessary. Overall, a solid understanding of these 
patterns empowers developers to design and implement software architectures that stand the test of time and meet the changing needs of users 
and stakeholders.
