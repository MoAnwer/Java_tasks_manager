import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    final String RESET = "\u001B[0m";
    final String WHITE_TEXT = "\u001B[37m";
    final String RED_BACKGROUND = "\u001B[44m";
    final String TEXT_BOLD = "\u001B[1m";

    TaskHandler taskHandler = new TaskHandler();

    Scanner scanner = new Scanner(System.in);

    System.out.println(" \t\t\t\t\t\t\t" + RED_BACKGROUND + WHITE_TEXT + " Tasks App " + RESET);
    System.out.println("----------------------------------------------------------------------------------------------------------------------------");


    boolean finshProgram = false;

    while (!finshProgram) {

      mainMenu();

      System.out.print(TEXT_BOLD + "\nEnter the number of operation: " + RESET);

      int operation = scanner.nextInt();

      switch (operation) {
        
        case 1:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Create new task: " +"\u001B[0m" );
          System.out.println("---------------------------------------------");
          newTask(scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;
        case 2:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Update task: " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          updateTask(scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;
        case 3:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Delete task: " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          delete(scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;
        case 4:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Show Task : " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          showTask(scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;
        case 5:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Latest tasks list: " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          taskHandler.latestTasks(3);
          taskHandler.showLatestTasks();
          System.out.println("---------------------------------------------");
        break;
        case 6:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Tasks list: " + "\u001B[0m \n");
          taskHandler.tasksList();
          System.out.println("---------------------------------------------");
        break;
        case 7:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Done tasks list : " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          showTasksWithState("done", scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;
        case 8:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "In progress tasks list : " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          showTasksWithState("in progress", scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break;            
        case 9:
          System.out.println("---------------------------------------------");
          System.out.println("\u001B[1m" + "Canceled tasks list : " + "\u001B[0m");
          System.out.println("---------------------------------------------");
          showTasksWithState("canceled", scanner, taskHandler);
          System.out.println("---------------------------------------------");
        break; 
        case 0:
          System.out.println("\n---- Thank you for using my app ----\n");
          System.exit(0);
        break;   
        default: 
          System.out.println("---------------------------------------------");
          System.out.println("Invalid operation number!!");          
          System.out.println("---------------------------------------------");
        break;
      }
    }

  }


  public static void mainMenu() {

    final String RESET = "\u001B[0m";
    final String WHITE_TEXT = "\u001B[37m";
    final String RED_BACKGROUND = "\u001B[41m";

    System.out.println("Chose Operation : \n");

    System.out.println("\s\s1- Create Task");
    
    System.out.println("\s\s2- Update Task");
    
    System.out.println("\s\s3- Delete Task");

    System.out.println("\s\s4- Show Task");

    System.out.println("\s\s5- Latest Tasks List");

    System.out.println("\s\s6- Tasks List");

    System.out.println("\s\s7- Done Tasks List");

    System.out.println("\s\s8- In Progress Tasks List");

    System.out.println("\s\s9- Canceled Tasks List");

    System.out.println("\s\s0- Exit.");
    
  }

  public static void latestMenu() 
  {
    System.out.print("\t Latest Tasks");
    
    System.out.print("\t\t\t\t Latest Done TasListks");
    
    System.out.println("\t\t\t  Latest In Porgress Tasks");

    System.out.print(" ---------------------------------");
    System.out.print("\t ---------------------------------");
    System.out.println("\t --------------------------------------------");    
  }

  public static void newTask(Scanner scanner, TaskHandler taskHandler) {

    System.out.print("Enter task id: ");

    int id = scanner.nextInt();

    scanner.nextLine();

    System.out.print("Enter task title: ");

    String title = scanner.nextLine();

    System.out.print("Enter task description : ");

    String description = scanner.nextLine();
    
    System.out.print("Enter task state: ");

    String state = scanner.nextLine();

    System.out.print("Enter task date: ");

    String date = scanner.nextLine();

    taskHandler.createTask(new Task(id, title, description, date, state));
    System.out.println("---------------------------------------------");
    System.out.println("ID: " + id + ", Title: " + title + "\s, " + "Description: " + description + "\s, " + "State : " + state + "\s, " + " Date : " + date);
  }

  public static void updateTask(Scanner scanner, TaskHandler taskHandler) {

    System.out.print("Enter task id: ");

    int id = scanner.nextInt();

    
    if(!taskHandler.isExist(id)) {
      
      System.out.println("---------------------------------------------");
      System.out.println("\u001B[37m" + "\u001B[41m" + " ERROR: " + "\u001B[0m" + " Task is Not Found :(");

      return;

    } else {

      
      scanner.nextLine();

      
      System.out.print("Enter new task title: ");

      String title = scanner.nextLine();

      System.out.print("Enter new task description : ");

      String description = scanner.nextLine();
      
      System.out.print("Enter new task state: ");

      String state = scanner.nextLine();

      System.out.print("Enter new task date: ");

      String date = scanner.nextLine();

      taskHandler.updateTask(id, new Task(id, title, description, date, state));

      System.out.println("---------------------------------------------");

      System.out.println("\u001B[37m" + "\u001B[42m" + " Success: " + "\u001B[0m" + " Task Updated Successfully !!");
     

    }
  }

  public static void delete(Scanner scanner, TaskHandler taskHandler) {

    System.out.print("Enter task id: ");

    int id = scanner.nextInt();
    
    System.out.print("---------------------------------------------\n");

    if (!taskHandler.isExist(id)) {
      
      System.out.println("\u001B[37m" + "\u001B[41m" + " ERROR: " + "\u001B[0m" + " Task is Not Found :(");
      
    } else {

      taskHandler.deleteTask(id);

    }
    
  }

  public static void showTask(Scanner scanner, TaskHandler taskHandler)   {

    System.out.print("Enter task id: ");

    int id = scanner.nextInt();

    System.out.print("---------------------------------------------\n");
  
    if(taskHandler.isExist(id)) {
      
      taskHandler.showTask(id);
      
    } else {

      System.out.println("\u001B[37m" + "\u001B[41m" + " ERROR: " + "\u001B[0m" + " Task is Not Found :(");

    }

  }

  public static void doneTask(Scanner scanner, TaskHandler taskHandler) {

    System.out.print("Enter task id: ");

    int id = scanner.nextInt();

    taskHandler.showTask(id);
  }

  public static void showTasksWithState(String state, Scanner scanner, TaskHandler taskHandler) {

    ArrayList<Task> tasks = new ArrayList<Task>();
    tasks = taskHandler.getTasksWithState(state);

    
    if (state.equals("done") || state.equals("in progress")|| state.equals("canceled")) {
            
      if(tasks.size() > 0) {

        for (Task task : tasks) {
          task.displayInfo();
        }

      } else {

        System.out.println("\u001B[37m" + "\u001B[41m" + "Threre is no \"" +  state.toUpperCase() + "\" tasks yet :("  + "\u001B[0m");

      }
      
      
    } else {

      System.out.println( "\u001B[37m" + "\u001B[41m" + " ERROR: " + "\u001B[0m" + " Unknow Task State !!");
      
    }

  }

}
