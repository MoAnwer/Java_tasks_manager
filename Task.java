/**
 * Task
 */
public class Task {

  private int id;
  private String title;
  private String description;
  private String date;
  private String state;

  public Task(int id, String title, String description, String date, String state) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.state = state;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public String getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getState() {
    return state;
  }

  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void displayInfo() {
    System.out.println(
        "ID: " + this.getId() + ", Title: " + this.getTitle() + "\s, " + "Description: " + this.getDescription() + "\s, " + "State : " + this.getState() + "\s, " + " Date : " + this.getDate()
      );
  }
  
}