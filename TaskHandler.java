import java.util.ArrayList;

public class TaskHandler {
  
  private ArrayList<Task> tasks;
  private final String NO_TASKS = "Threre is no tasks yet :(";
  private final String INVALID_TASK_STATE = "Unknow task state !!";

  public TaskHandler() {
    tasks = new ArrayList<Task>();
  }

  public void tasksList() {
    
    if(tasks.size() == 0) {
      System.out.println(this.NO_TASKS);
    }

    for (Task task : tasks) {
      task.displayInfo();
    }
  }

  public void createTask(Task task) {
    tasks.add(task);
    this.makeTask(task.getState(), task);
  }

  public void updateTask(int id, Task task) {
    
    for (Task iterableTask : tasks) {

      if (iterableTask.getId() == id) {

        iterableTask.setTitle(task.getTitle());
        iterableTask.setDescription(task.getDescription());
        iterableTask.setState(task.getState());
        iterableTask.setDate(task.getDate());

      } 
      
    } 

    this.makeTask(task.getState(), task);
    
  }

  public void deleteTask(int id) {
      
      for (Task iterableTask : tasks) {
  
        if (iterableTask.getId() == id) {
  
          tasks.remove(tasks.indexOf(iterableTask));

          System.out.println("Task Deleted Sucsessfully !!");
          return;
  
        } 
      } 
  }

  public void showTask(int id) {

    for (Task task : tasks) {

      if (task.getId() == id) {

        task.displayInfo();

      }
      
    } 

  }

  
  public void showLatestTasks() {

    for (Task task : tasks) {

      System.out.println(task.getTitle());

    }
    
  }

  public ArrayList<Task> latestTasks(int count) {

    ArrayList<Task> latestTasks = new ArrayList<Task>();

    try {

      if(latestTasks.size() < count) {

        count = latestTasks.size();

        for (int i = count; i < 0; i--) {
    
          latestTasks.add(tasks.get(tasks.size() - i));
    
        }
      }

    } catch (Exception e) {

      System.out.println(this.NO_TASKS);

    }
    
    return latestTasks;
  }


  public ArrayList<Task> getTasksWithState(String state, int count) {

    ArrayList<Task> fetchedTasks = new ArrayList<Task>();

    if (state.equals("done")) {

      try {

        if (tasks.size() < count) {

          count = tasks.size(); // To avoid "Null Errors" if the needed count greater than tasks array size

          for (Task task : tasks) {

            if(task.getState().equals("done")) { fetchedTasks.add(task); }
            
          }

        }

      } catch (Exception e) {

        System.out.println(e.getMessage());
        
      }

    } else if (state.equals("in progress")) {
      
      try {

        if (tasks.size() < count) {

          count = tasks.size(); // To avoid "Null Errors" if the needed count greater than tasks array size

          for (Task task : tasks) {

            if(task.getState().equals("in progress")) { fetchedTasks.add(task); }
            
          }

        }

      } catch (Exception e) {

        System.out.println(e.getMessage());

      }
      
    } else if (state.equals("canceled")) {
      try {

        if (tasks.size() < count) {

          count = tasks.size(); // To avoid "Null Errors" if the needed count greater than tasks array size

          for (Task task : tasks) {

            if(task.getState().equals("canceled")) { fetchedTasks.add(task); }
            
          }

        }

      } catch (Exception e) {

        System.out.println(e.getMessage());
        
      }
    }

    return fetchedTasks;
  }


  public ArrayList<Task> getTasksWithState(String state) {

    ArrayList<Task> fetchedTasks = new ArrayList<Task>();

    try {

        for (Task task : tasks) {

          if(task.getState().equals(state)) { 

            fetchedTasks.add(task); 

          }
               
        }
        
    } catch (Exception e) {

      System.out.println(this.INVALID_TASK_STATE);

    }

    return fetchedTasks;

  }


  public void makeTask(String state, Task task) {
    switch (state) {
      case "done":
        task.setState(state);
      break;
      case "in progress":
        task.setState(state);
      break;
      case "canceled":
        task.setState(state);
      break;
      default:
        System.out.println(this.INVALID_TASK_STATE);
      break;    
    }
  }

  public boolean isExist(int id) {

    boolean isExist = false;

    for (Task task : tasks) {
      if (task.getId() == id) {
        isExist = true;
      }
    }

    return isExist;

  }

}