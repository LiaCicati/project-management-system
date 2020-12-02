package Model;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> tasks;

  public TaskList()
  {
    this.tasks = new ArrayList<>();
  }

  public void addTask(Task task)
  {
    tasks.add(task);
  }

  public void removeTask(Task task)
  {
    tasks.remove(task);
  }

  public Task getTaskByID(int ID)
  {
    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getID() == ID)
        return tasks.get(i);
    }
    return null;
  }

  public Task getTaskByTitle(String title)
  {
    for (int i = 0; i < tasks.size(); i++)
    {
      if (tasks.get(i).getTitle().equals(title))
        return tasks.get(i);
    }
    return null;
  }

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

  public ArrayList<Task> getAllTasks()
  {
    return tasks;
  }

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

  public Task getTask(int index)
  {
    return tasks.get(index);
  }

  public int getSize()
  {
    return tasks.size();
  }

  @Override public String toString()
  {
    return "Tasks:" + tasks;
  }
}

