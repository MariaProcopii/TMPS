package model;

import builder.LongTaskBuilder;
import enumClasses.TaskStatus;
import factory.StyleTaskFactory;
import styleTask.StyleTaskStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskManagerCLI {
    private TaskManager taskManager;
    private Scanner scanner;

    public TaskManagerCLI(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n-------------Task Manager CLI-------------\n");
            System.out.println("[1]. Add Long Task");
            System.out.println("[2]. Add Short Task");
            System.out.println("[3]. List Task by ID");
            System.out.println("[4]. List All Tasks");
            System.out.println("[5]. Change Task Style");
            System.out.println("[6]. Delete LongTask");
            System.out.println("[7]. Exit");
            System.out.print("\nSelect an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addLongTask();
                case 2 -> addShortTask();
                case 3 -> listTaskById();
                case 4 -> listAllTasks();
                case 5 -> pickStyleMethod();
                case 6 -> deleteTask();
                case 7 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void addShortTask() {
        System.out.println("\n=======Add Short Task=======\n");

        System.out.print("Enter description (mandatory): ");
        String description = scanner.nextLine();

        while (description.isEmpty()){
            System.out.print("Enter description (mandatory): ");
            description = scanner.nextLine();
        }

        ShortTask shortTask = new ShortTask();
        shortTask.setDescription(description);

        System.out.print("Enter assignee (optional): ");
        String assigneeName = scanner.nextLine();
        if (!assigneeName.isEmpty()) {
            User assignee = new User(assigneeName, "password");
            shortTask.setAssignee(assignee);
        }

        taskManager.addTask(shortTask);
        System.out.println("Task added successfully.");
    }

    private void addLongTask(){
        System.out.println("\n=======Add Long Task=======\n");

        System.out.print("Enter description (mandatory): ");
        String description = scanner.nextLine();

        while (description.isEmpty()){
            System.out.print("Enter description (mandatory): ");
            description = scanner.nextLine();
        }

        LongTaskBuilder taskBuilder = new LongTaskBuilder(description);

        // Ask for optional fields
        System.out.print("Enter title (optional): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            taskBuilder.title(title);
        }

        System.out.print("Enter due date (yyyy-MM-dd, optional): ");
        String dueDateString = scanner.nextLine();
        if (!dueDateString.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dueDate = dateFormat.parse(dueDateString);
                taskBuilder.dueDate(dueDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Task not added.");
                return;
            }
        }

        System.out.print("Enter task status [TODO, IN_PROGRESS, COMPLETED, ON_HOLD, optional]: ");
        String statusString = scanner.nextLine();
        if (!statusString.isEmpty()) {
            TaskStatus status = TaskStatus.valueOf(statusString);
            taskBuilder.status(status);
        }

        System.out.print("Enter assignee (optional): ");
        String assigneeName = scanner.nextLine();
        if (!assigneeName.isEmpty()) {
            User assignee = new User(assigneeName, "password"); // Create a temporary user
            taskBuilder.assignee(assignee);
        }

        LongTask task = taskBuilder.build();
        taskManager.addTask(task);
        System.out.println("Task added successfully.");
    }

    private void listTaskById() {
        System.out.println("\n=======Task by ID=======\n");
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        Task task = taskManager.getTaskById(taskId);

        if (task != null) {
            System.out.println("LongTask found:");
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }
    }
    private void listAllTasks() {
        System.out.println("\n=======All Tasks=======\n");
        taskManager.listTask();
    }

    private void pickStyleMethod(){
        System.out.println("\n=======Style Task=======\n");
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();
        Task task = taskManager.getTaskById(taskId);

        String option = "";
        if (task != null) {

            boolean back = false;
            while (!back){
                System.out.println("Enter Style method: [ text color, background color, text format ]");
                System.out.println("<- Return Back: [B/b]");

                option = scanner.nextLine().toLowerCase();
                if(option.equals("b")){
                    back = true;
                }
                else {
                    StyleTaskFactory styleTaskFactory = new StyleTaskFactory();
                    StyleTaskStrategy strategy = styleTaskFactory.getStyleStrategy(option);

                    taskManager.setStrategy(strategy);
                    String argument = pickStyleArg(option);
                    taskManager.styleTask(task, argument);
                }
            }
        } else {
            System.out.println("Task not found.");
        }
    }

    private String pickStyleArg(String option){

        if(option.equals("text format")){
            System.out.println("Pick text format: [ bold, italic, underline ]");
        } else {
            System.out.println("Pick color: [ black, green, yellow, peach, magenta, cyan, white ] ");
        }
        return scanner.nextLine().toLowerCase();
    }

    private void deleteTask() {
        System.out.print("Enter task ID: ");
        int taskId = scanner.nextInt();
        if(taskManager.getTaskById(taskId) == null) {System.out.println("Task not found.");}
        else {taskManager.deleteTask(taskId);}
    }
}
