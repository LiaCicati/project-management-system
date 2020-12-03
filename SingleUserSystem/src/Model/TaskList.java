package Model;

import java.util.ArrayList;

/**
 * @author
 * @version v.1 2d December 2020
 */
public class TaskList
{
  private ArrayList<Task> tasks;

  /**
   * Constructor for the tasks
   */
  public TaskList()
  {
    this.tasks = new ArrayList<>();
  }

  /**
   * Adding a task to a list of tasks
   * @param task the added task
   */
  public void addTask(Task task)
  {
    tasks.add(task);
  }

  /**
   * Removing a task from the list
   * @param task the removed task
   */
  public void removeTask(Task task)
  {
    tasks.remove(task);
  }

  /**
   * Getting a task from the list by its specific id
   * @param ID the ID of the task
   * @return the task with this specific id or null if nothing is found
   */
  public Task getTaskByID(int ID)
  {
    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getID() == ID)
        return tasks.get(i);
    }
    return null;
  }

  /**
   * Getting a task from the list by its specific title
   * @param title the title of the task
   * @return the task with its specific title or null if nothing is found
   */
  public Task getTaskByTitle(String title)
  {
    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getTitle().equals(title))
        return tasks.get(i);
    }
    return null;
  }

  /**
   * Getting a task by its responsible team member
   * @param responsibleTeamMember the responsible team member for the task
   * @return an array list with all tasks that a specific team member is responsible for
   */
  public ArrayList<Task> getTaskByResponsibleTeamMember(
      TeamMember responsibleTeamMember)
  {
    ArrayList<Task> byResponsibleTeamMember = new ArrayList<>();

    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getResponsibleTeamMember().equals(responsibleTeamMember))
        byResponsibleTeamMember.add(tasks.get(i));
    }
    return byResponsibleTeamMember;
  }

  /**
   * Getting all tasks
   * @return an array list of all tasks
   */
  public ArrayList<Task> getAllTasks()
  {
    return tasks;
  }

  /**
   * Getting all tasks with a specific deadline from the task's list
   * @param deadline the deadline for the task
   * @return an array list with all tasks that correspond to a specific deadline
   */
  public ArrayList<Task> getByDeadline(MyDate deadline)
  {
    ArrayList<Task> byDeadline = new ArrayList<>();
    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getDeadline() == deadline)
      {
        byDeadline.add(tasks.get(i));
      }
    }
    return byDeadline;
  }

  /**
   *  Getting a task from the list at a specific index
   * @param index the index of the task
   * @return the task at the specified index
   */
  public Task getTask(int index)
  {
    return tasks.get(index);
  }

  /**
   * Getting the total number of tasks from the list
   * @return total number of tasks
   */
  public int getSize()
  {
    return tasks.size();
  }

  /**
   * Getting the information about all tasks
   * @return a string with all needed information about all tasks
   */
  @Override public String toString()
  {
    return "Tasks:" + tasks;
  }
}

