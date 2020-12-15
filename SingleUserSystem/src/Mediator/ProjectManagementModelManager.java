package Mediator;

import Model.*;

public class ProjectManagementModelManager implements ProjectManagementModel
{
  private ProjectList projectList;
  private TeamMemberList teamMemberList;
  private RequirementList requirementList;
  private TaskList taskList;
  private ProjectManagementPersistence file;

  public ProjectManagementModelManager()
  {
    this.projectList = new ProjectList();
    this.teamMemberList = new TeamMemberList();
    createDummyData();
  }

  private void createDummyData()
  {
    Project project1 = new Project("Rental Company", new MyDate(18, 12, 2020),
        35, "some description");
    Project project2 = new Project("VIA University", new MyDate(23, 12, 2020),
        38, "some description");
    projectList.addProject(project1);
    projectList.addProject(project2);

    Name name1 = new Name("Bob", "Turquoise");
    Name name2 = new Name("Evan", "Peters");
    TeamMember teamMember1 = new TeamMember(name1, 244);
    TeamMember teamMember2 = new TeamMember(name2, 128);

    project1.addTeamMember(teamMember1);
    project1.addTeamMember(teamMember2);
    Requirement requirement1 = new Requirement(33,
        "As a customer I want access to a website", Type.FUNCTIONAL, 25,
        teamMember1, new MyDate(25, 12, 2020));
    Requirement requirement2 = new Requirement(46,
        "As a customer I want access to a website", Type.FUNCTIONAL, 30,
        teamMember2, new MyDate(28, 12, 2020));
    project1.addRequirement(requirement1);
    project1.addRequirement(requirement2);

    Task task1 = new Task(requirement1, 2, "To do", "some text", 15.5,
        teamMember1, new MyDate(3, 1, 2021));
    requirement1.addTask(task1);
    requirement1.addTeamMember(teamMember1);
    requirement1.addTeamMember(teamMember2);
    teamMember1.registerTime(25, task1);
    //        teamMember2.registerTime(30, task1);

  }

  @Override public TeamMember getTeamMemberByName(Name name)
  {
    for (Project project : projectList.getAllProjects())
    {
      for (TeamMember teamMember : project.getAllTeamMembers()
          .getAllTeamMembers())
      {
        if (teamMember.getName().equals(name))
        {
          return teamMember;
        }
      }
    }
    return null;
  }

  @Override public void addTask(int requirementID, int projectID, Task task)
  {
    projectList.getProjectById(projectID).getAllRequirements()
        .getByID(requirementID).addTask(task);

  }

  @Override public void addTeamMember(int projectID, TeamMember teamMember)
  {
    projectList.getProjectById(projectID).addTeamMember(teamMember);
  }

  @Override public void editTeamMember(int projectID, int ID,
      TeamMember teamMember, String role)
  {
    projectList.getProjectById(projectID).getAllTeamMembers()
        .getTeamMemberById(ID).changeRole(role);
    projectList.getProjectById(projectID).getAllTeamMembers()
        .getTeamMemberById(ID)
        .editTeamMember(teamMember.getName(), teamMember.getId());
  }

  @Override public void removeTeamMember(TeamMember teamMember)
  {
    for (Project project : projectList.getAllProjects())
    {
      if (project.getTeamMember(teamMember).equals(teamMember))
      {
        project.removeTeamMember(teamMember);
      }
    }
  }

  @Override public void addTaskToRequirement(Requirement requirement, Task task)
  {
    for (Project project : projectList.getAllProjects())
    {
      for (Requirement requirementTest : project.getAllRequirements()
          .getRequirements())
      {
        if (requirementTest.equals(requirement))
        {
          requirementTest.addTask(task);
        }
      }
    }
  }

  @Override public void removeTaskFromRequirement(Requirement requirement,
      Task task)
  {
    for (Project project : projectList.getAllProjects())
    {
      for (Requirement requirementTest : project.getAllRequirements()
          .getRequirements())
      {
        if (requirementTest.equals(requirement))
        {
          requirementTest.removeTask(task);
        }
      }
    }
  }

  @Override public void removeTeamMemberFromTask(Task task,
      TeamMember teamMember)
  {
    for (Project project : projectList.getAllProjects())
    {
      for (Requirement requirement : project.getAllRequirements()
          .getRequirements())
      {
        for (Task taskTest : requirement.getAllTasks().getAllTasks())
        {
          if (taskTest.equals(task))
          {
            taskTest.removeTeamMember(teamMember);
          }
        }
      }
    }
  }

  @Override public void addRequirement(int projectID, Requirement requirement)
  {
    projectList.getProjectById(projectID).addRequirement(requirement);
  }

  @Override public void removeRequirementFromProject(Project project,
      int requirementID)
  {
    for (Project projectTemp : projectList.getAllProjects())
    {
      if (projectTemp.equals(project))
      {
        projectTemp.removeRequirement(requirementID);
      }
    }
  }

  @Override public void addProject(Project project, String title, int ID)
  {
    projectList.addProject(project);
  }

  @Override public void removeProject(Project project)
  {
    projectList.removeProject(project);
  }

  @Override public TeamMemberList getAllTeamMembers(Project project)
  {
    return project.getAllTeamMembers();
  }

  @Override public TaskList getAllTasks(Requirement requirement)
  {
    return requirement.getAllTasks();
  }

  @Override public RequirementList getAllRequirements(Project project)
  {
    return project.getAllRequirements();
  }

  @Override public TaskList getAllTasks(Project project,
      Requirement requirement)
  {
    if (project.getAllRequirements().contains(requirement))
    {
      return requirement.getAllTasks();
    }
    throw new IllegalArgumentException(
        "Could not find any tasks belonging to this requirement");
  }

  @Override public TeamMemberList getAllTeam(Project project,
      Requirement requirement, Task task)
  {
    if (project.getAllRequirements().contains(requirement) || requirement
        .getAllTasks().contains(task))
    {
      return task.getAllTeamMembers();
    }
    throw new IllegalArgumentException(
        "Could not find any team members belonging to this task");
  }

  @Override public ProjectList getAllProjects()
  {
    return projectList;
  }

  @Override public Project getProject(String title)
  {
    return projectList.getProjectByTitle(title);
  }

  @Override public void reorderRequirements(Project project, int position,
      int newPosition)
  {
    project.getAllRequirements().reorder(position, newPosition);
  }

  @Override public int getNumberOfTasks(Requirement requirement)
  {
    return requirement.countTasks();
  }

  @Override public int getNumberOfRequirements(Project project)
  {
    return project.getNumberOfRequirements();
  }

  @Override public int getNumberOfProjects()
  {
    return projectList.getNumberOfProjects();
  }

  @Override public TeamMember get(Project project, int index)
  {
    return project.getAllTeamMembers().get(index);
  }

  @Override public TeamMember getTeamMemberById(int ID)
  {
    for (int i = 0; i < teamMemberList.getSize(); i++)
    {
      if (teamMemberList.get(i).getId() == ID)
      {
        return teamMemberList.get(i);
      }
    }
    return null;
  }

  @Override public void editTask(Task task, int taskID, int projectID,
      int requirementID, String status)
  {
    projectList.getProjectById(projectID).getAllRequirements()
        .getByID(requirementID).getAllTasks().getTaskByID(taskID)
        .editTask(task.getTitle(), task.getDescription(),
            task.getEstimatedTime(), task.getResponsibleTeamMember(),
            task.getDeadline());
    projectList.getProjectById(projectID).getAllRequirements()
        .getByID(requirementID).getAllTasks().getTaskByID(taskID)
        .setStatus(status);
  }

  @Override public void editRequirement(int projectID, int ID,
      Requirement requirement, String status)
  {
    projectList.getProjectById(projectID).getAllRequirements().getByID(ID)
        .editRequirement(requirement.getID(), requirement.getUserStory(),
            requirement.getType(), requirement.getEstimatedTime(),
            requirement.getResponsibleTeamMember(), requirement.getDeadline());
    projectList.getProjectById(projectID).getAllRequirements().getByID(ID)
        .setStatus(status);
  }

  @Override public void changeStatus(Project project, String status)
  {
    project.changeStatus(status);
  }

  @Override public void changeRole(TeamMember teamMember, String role)
  {
    teamMember.changeRole(role);
  }

  @Override public void editProject(int projectID, String title, int customerID,
      String description, MyDate deadline, String status)
  {
    projectList.getProjectById(projectID)
        .editProject(title, customerID, description, deadline);
    projectList.getProjectById(projectID).changeStatus(status);
  }

  public Project getProject(int index)
  {
    return projectList.getProject(index);
  }

  @Override public TeamMember getTeamMemberAtIndex(int projectID, int index)
  {
    return projectList.getProjectById(projectID).getTeamMemberAtIndex(index);
  }

  @Override public Project getProjectByID(int id)
  {
    return projectList.getProjectById(id);
  }

  @Override public TeamMemberList getTeamMembers()
  {
    return teamMemberList;
  }

  public int getNumberOfTeamMembers()
  {
    return teamMemberList.getSize();
  }

  public RequirementList getAllRequirements()
  {
    return requirementList;
  }

  public TeamMemberList getTeamMemberList(Project project)
  {
    return project.getAllTeamMembers();
  }

  @Override public TeamMember getAllTeamMembers(int projectID,
      int requirementID, int taskID, int teamMemberID)
  {
    return projectList.getProjectById(projectID).getAllRequirements()
        .getByID(requirementID).getAllTasks().getTaskByID(taskID)
        .getAllTeamMembers().getTeamMemberById(teamMemberID);
  }

  @Override public Requirement getRequirementByID(int id)
  {
    for (int i = 0; i < requirementList.getSize(); i++)
    {
      if (requirementList.getRequirement(i).getID() == id)
      {
        return requirementList.getRequirement(i);
      }
    }
    return null;
  }

  @Override public void addHours(int projectID, int requirementID, int taskID,
      int teamMemberID, double hours)
  {
    projectList.getProjectById(projectID).getAllRequirements()
        .getByID(requirementID).getAllTasks().getTaskByID(taskID)
        .getAllTeamMembers().getTeamMemberById(teamMemberID).registerTime(hours,
        projectList.getProjectById(projectID).getAllRequirements()
            .getByID(requirementID).getAllTasks().getTaskByID(taskID));
  }
}