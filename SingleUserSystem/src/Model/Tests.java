package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Tests
{

  Project project1 = new Project("Rental Company", new MyDate(18, 12, 2020), 35,
      "some description");
  Project project2 = new Project("VIA University", new MyDate(23, 12, 2020), 38,
      "some description");
  Project project3 = new Project("Rental Company", new MyDate(16, 12, 2018), 13,
      "some text");

  TeamMember teamMember1 = new TeamMember(new Name("Matthew", "Gray"), 2);
  TeamMember teamMember2 = new TeamMember(new Name("Evan", "Peters"), 3);
  TeamMember productOwner = new ProductOwner(new Name("Bob", "Dylan"), 444);

  Requirement requirement1 = new Requirement(23, "some text", Type.FUNCTIONAL,
      35, teamMember2, new MyDate(12, 1, 2021));
  Requirement requirement2 = new Requirement(29, "some text",
      Type.NON_FUNCTIONAL, 30, teamMember1, new MyDate(12, 1, 2022));

  Task task1 = new Task(requirement1, 26, "Some title", "Some description",
      25.5, teamMember1, new MyDate(19, 3, 2021));
  Task task2 = new Task(requirement1, 26, "Some title", "Some description",
      30.5, teamMember1, new MyDate(14, 3, 2021));
  Task task3 = new Task(requirement1, 93, "Some title", "Some description",
      40.5, teamMember2, new MyDate(19, 3, 2022));

  @Test void addProject()
  {
    // Two array lists are initialised
    ProjectList projectListCheck = new ProjectList();
    ProjectList actualProjectList = new ProjectList();
    // Add 3 projects to the actual project list while the check project list remains empty
    actualProjectList.addProject(project1);
    actualProjectList.addProject(project2);
    actualProjectList.addProject(project3);

    System.out.println(
        "Number of projects in the actual project list: " + actualProjectList
            .getNumberOfProjects());
    System.out.println(
        "Number of projects in the check project list: " + projectListCheck
            .getNumberOfProjects());
    // The two array lists are not alike meaning that the projects have been successfully added to the actual project list
    assertNotEquals(projectListCheck.getNumberOfProjects(),
        actualProjectList.getNumberOfProjects());

  }

  @Test void getStatusOfProjectCase2()
  {
    System.out.println(project3.getNumberOfRequirements()); // 0
    System.out.println(project3
        .getStatus()); // Not Started because there are no requirements added to it yet
    System.out.println(requirement1.getStatus()); // Not Started
    project3.addRequirement(requirement1);
    System.out.println("Status: " + project3
        .getStatus()); // Started because a requirement has been added to the project
    assertEquals("Started", project3.getStatus()); // Success !
  }

  @Test void getStatusOfProjectCase3()
  {
    System.out.println(project3.getStatus()); // Not Started because empty
    System.out.println(requirement1.getStatus()); // Not Started
    project3.addRequirement(requirement1);
    System.out.println(project3
        .getStatus()); // Should return Started because a requirement was added to the project
    System.out.println(requirement1
        .getStatus()); // Should return Not Started because there are no tasks added to the requirement yet
    requirement1.addTask(task1);
    System.out.println(task1
        .getStatus()); // Not Started because by default it's set to that (can change if edit)
    System.out.println(requirement1
        .getStatus()); // Should return Started because a task has been added to the requirement
    task1.setStatus(Task.ENDED); // change the status to end when editing
    System.out.println(task1.getStatus()); // Ended
    System.out.println(requirement1.countTasks()); // 1
    System.out.println(requirement1
        .getStatus()); // Should return Ended because all tasks are in Ended state
    requirement1.setStatus(Requirement.APPROVED); // Approve task
    System.out.println(requirement1.getStatus()); // Approved
    System.out.println(project3.getNumberOfRequirements()); // 1
    System.out.println(project3
        .getStatus()); // Should return Ended because all requirements belonging to this specific project are Approved
    assertEquals("Ended", project3.getStatus()); // Success !!
  }

  @Test void getStatusOfRequirementCase2()
  {
    System.out.println(requirement1.getStatus()); // Not Started because empty
    task1.setStatus(Task.STARTED);
    task2.setStatus(Task.NOT_STARTED);
    TaskList taskList = new TaskList();
    taskList.addTask(task1);
    taskList.addTask(task2);
    System.out.println(
        "Are all the tasks in the list in ended state: " + taskList
            .areInEndedState()); // false
    requirement1.addTask(task1);
    requirement1.addTask(task2);
    System.out.println(requirement1.countTasks()); // 2
    System.out.println("Status of the requirement: " + requirement1
        .getStatus()); // Should be Started
    assertEquals("Started", requirement1.getStatus());

  }

  @Test void getStatusOfRequirementCase3()
  {
    System.out.println(requirement1.getStatus()); // Not Started because empty
    task1.setStatus(Task.STARTED);
    task2.setStatus(Task.ENDED);
    TaskList taskList = new TaskList();
    taskList.addTask(task1);
    taskList.addTask(task2);
    System.out.println(
        "Are all the tasks in the list in ended state: " + taskList
            .areInEndedState());
    requirement1.addTask(task1);
    requirement1.addTask(task2);
    System.out.println(requirement1.countTasks()); // 2
    System.out.println("Status of the requirement: " + requirement1
        .getStatus()); // Should be Started
    assertEquals("Started", requirement1.getStatus());

  }


  @Test void removeProject()
  {
    // Two array lists are created
    ProjectList projectListCheck = new ProjectList();
    ProjectList actualProjectList = new ProjectList();
    // Adding projects to the project list check
    projectListCheck.addProject(project1);
    projectListCheck.addProject(project2);
    // Adding projects to the actual project list
    actualProjectList.addProject(project1);
    actualProjectList.addProject(project2);
    // Removing a previously added project from the actual project list
    actualProjectList.removeProject(project1);

    System.out.println(
        "Number of projects in the project list check: " + projectListCheck
            .getNumberOfProjects()); // 2
    System.out.println(
        "Number of projects in the actual project list: " + actualProjectList
            .getNumberOfProjects()); // 1
    // The two array lists are not alike meaning that a project was successfully removed from the actual project list
    assertNotEquals(projectListCheck.getNumberOfProjects(),
        actualProjectList.getNumberOfProjects());
  }

  @Test void addTeamToAProject()
  {
    project1.addTeamMember(teamMember1);
    project1.addTeamMember(teamMember2);
    System.out.println(
        "Number of team members assigned to the first project: " + project1
            .getAllTeamMembers().getSize()); // 2
    assertEquals(2, project1.getAllTeamMembers().getSize());
  }

  @Test void editProject()
  {
    // A project with same data as project 1 is created
    Project projectCheck = new Project("Rental Company",
        new MyDate(18, 12, 2020), 35, "some description");
    System.out.println("Before editing data: " + "\n" + project1);
    project1.editProject("IT Minds", 39, "some description",
        new MyDate(18, 12, 2020));
    System.out
        .println("After editing title and customer ID: " + "\n" + project1);
    assertNotEquals(projectCheck, project1);

  }

  @Test void addRequirementsToAProject()
  {
    project2.addRequirement(requirement1);
    project2.addRequirement(requirement2);
    System.out.println(
        "Number of requirements added to the first project: " + project2
            .getAllRequirements().getSize()); // 2
    assertEquals(2, project2.getAllRequirements().getSize());
  }

  @Test void editRequirement()
  {
    // A requirement with same data as requirement 1 is created
    Requirement requirementCheck = new Requirement(23, "some text",
        Type.FUNCTIONAL, 35, teamMember2, new MyDate(12, 1, 2021));
    System.out.println("Before editing: " + "\n" + requirement1);
    requirement1
        .editRequirement(39, "some text", Type.NON_FUNCTIONAL, 35, teamMember2,
            new MyDate(12, 1, 2021));
    System.out.println(
        "After editing ID and responsible team member: " + "\n" + requirement1);
    assertNotEquals(requirementCheck, requirement1);
  }

  @Test void removeTeamMemberFromAProject()
  {
    project1.addTeamMember(teamMember1);
    project1.addTeamMember(teamMember2);
    System.out.println(
        "Number of team members assigned to the project before removing: "
            + project1.getAllTeamMembers().getSize()); // 2
    project1.removeTeamMember(teamMember1);
    System.out.println(
        "Number of team members assigned to the project after removing: "
            + project1.getAllTeamMembers().getSize()); // 1
    assertEquals(1, project1.getAllTeamMembers().getSize());
  }

  @Test void editTeamMember()
  {
    // A team member with same data as team member 1 is created
    TeamMember teamMemberCheck = new TeamMember(new Name("Matthew", "Gray"), 2);
    System.out.println("Before editing: " + teamMember1);
    teamMember1.editTeamMember(new Name("Matthew", "Gray"), 6);
    System.out.println("After editing the id: " + teamMember1);
    assertNotEquals(teamMemberCheck, teamMember1);
  }

  @Test void removeRequirementFromAProject()
  {
    project1.addRequirement(requirement1);
    project1.addRequirement(requirement2);
    System.out.println(
        "Number of requirements added to the project before changes: "
            + project1.getAllRequirements().getSize()); // 2
    project1.removeRequirement(requirement1);
    project1.removeRequirement(requirement2);
    System.out.println(
        "Number of requirements added to the project after removing all: "
            + project1.getAllRequirements().getSize()); // 0
    assertEquals(0, project1.getAllRequirements().getSize());

  }

  @Test void reorderRequirement()
  {
    // Two array lists of requirements are created
    RequirementList requirementsCheck = new RequirementList();
    RequirementList actualRequirementList = new RequirementList();
    //Adding same requirements to both array lists
    requirementsCheck.addRequirement(requirement1);
    requirementsCheck.addRequirement(requirement2);
    actualRequirementList.addRequirement(requirement1);
    actualRequirementList.addRequirement(requirement2);
    System.out.println("Before reordering: " + "\n" + actualRequirementList);
    //Reordering the actual array list
    actualRequirementList.reorder(0, 1);
    System.out.println("After reordering: " + "\n" + actualRequirementList);
    // Checking if requirement from the actual array list that was replaced from index 0 to 1 is equal to the requirement at index 0 before reordering
    assertEquals(actualRequirementList.getRequirement(0),
        requirementsCheck.getRequirement(1));

  }

  @Test void addTaskToARequirement()
  {
    System.out.println(
        "Number of tasks assigned to a requirement: " + requirement1
            .getAllTasks().getSize()); // 0
    requirement1.addTask(task1);
    requirement1.addTask(task2);
    requirement1.addTask(task3);
    System.out.println(
        "Number of tasks assigned to a requirement after changes: "
            + requirement1.getAllTasks().getSize()); // 3
    assertEquals(3, requirement1.getAllTasks().getSize());
  }

  @Test void removeTaskFromARequirement()
  {
    requirement1.addTask(task1);
    requirement1.addTask(task3);
    System.out.println(
        "Number of tasks added to a requirement before changes: " + requirement1
            .getAllTasks().getSize()); // 2

    requirement1.removeTask(task3);
    System.out.println(
        "Number of tasks added to a requirement after changes: " + requirement1
            .getAllTasks().getSize()); // 1
    assertEquals(1, requirement1.getAllTasks().getSize());
  }

  @Test void editTask()
  {
    // Task with same data as task 1 is created
    Task taskCheck = new Task(requirement1, 26, "Some title",
        "Some description", 25.5, teamMember1, new MyDate(19, 3, 2021));
    System.out.println("Before editing: " + task1);
    task1.editTask("Some title", "some description", 35, teamMember2,
        new MyDate(19, 3, 2021));
    System.out.println(
        "After editing estimated time and responsible member: " + task1);
    assertNotEquals(taskCheck, task1);
  }

  @Test void registerTimeWorkedOnATask()
  {
    teamMember1.registerTime(23.5, task1);
    teamMember2.registerTime(20, task1);
    System.out
        .println("Time spent on the task : " + task1.getTimeSpent()); // 43.5
    assertEquals(43.5, task1.getTimeSpent());
  }

  @Test void getStatusOfARequirement()
  {
    System.out
        .println("Status of the requirement: " + requirement1.getStatus());
    System.out.println(requirement1.countTasks());
    requirement1.getStatus();
    assertEquals("Not Started", requirement1.getStatus());
  }

  @Test void getAllTasksWorkedByTeamMember()
  {
    // To do

  }

  @Test void getStatusOfATask()
  {
    System.out
        .println("Status of the task before changes: " + task1.getStatus());
    task1.setStatus(Task.STARTED);
    System.out.println("Status of the task: " + task1.getStatus());
    assertEquals("Started", task1.getStatus());

  }

  @Test void changeTeamMemberRoleInAProject()
  {
    project1.addTeamMember(teamMember1);
    project1.getAllTeamMembers().get(0).changeRole(productOwner.getRole());
    assertEquals("Product Owner",
        project1.getAllTeamMembers().get(0).getRole());
  }

  @Test void getInformationOfAProject()
  {
    project1.addTeamMember(teamMember1);
    project1.addTeamMember(teamMember2);
    project1.addTeamMember(productOwner);
    project1.addRequirement(requirement1);
    System.out.println(
        "Information about project 1: " + "\n" + project1 + "\n" + project1
            .getAllRequirements() + "\n" + project1.getAllTeamMembers());

  }

  @Test void getTimeSpentOnARequirement()
  {

    teamMember1.registerTime(30, task2);
    teamMember2.registerTime(40, task1);
    requirement2.addTask(task1);
    requirement2.addTask(task2);
    System.out.println(
        "Time spent on requirement 2: " + requirement2.getTimeSpent()); // 70
    System.out.println(requirement2.getTimeSpent());
    assertEquals(70, requirement2.getTimeSpent());

  }

  @Test void setCustomerIDForProject()
  {
    project1.setCustomerID(192);
    System.out.println("Customer ID related to the project: " + project1
        .getCustomerID()); // 192
    assertEquals(192, project1.getCustomerID());

  }

  @Test void getInformationAboutTeamMember()
  {
    project1.addTeamMember(teamMember1);
    project1.addRequirement(requirement2);
    System.out.println(project1.getTeamMemberByID(2));
  }

  @Test void getStatusOfProjectIfAllRequirementsAreApproved()
  {
    task1.setStatus(Task.ENDED);
    requirement1.addTask(task1);
    requirement2.addTask(task2);
    project1.addRequirement(requirement1);
    project1.addRequirement(requirement2);
    requirement1.setStatus(Requirement.APPROVED);
    requirement2.setStatus(Requirement.APPROVED);
    System.out.println(
        "Status of the requirement: " + requirement1.getStatus()); // Approved
    System.out.println(
        "Status of the requirement: " + requirement2.getStatus()); // Approved
    System.out.println("Number of requirements in the project: " + project1
        .getNumberOfRequirements());
    System.out
        .println("Status of the project: " + project1.getStatus()); // Ended
    assertEquals("Ended", project1.getStatus());
  }

  @Test void getStatusOfRequirementWhenAllTasksAreEnded()
  {
    System.out.println(requirement1.getStatus());
    project1.addRequirement(requirement1);
    task1.setStatus(Task.ENDED);
    task2.setStatus(Task.ENDED);
    TaskList taskList = new TaskList();
    taskList.addTask(task1);
    taskList.addTask(task2);
    System.out.println(
        "Are all the tasks in the list in ended state: " + taskList
            .areInEndedState());
    requirement1.addTask(task1);
    requirement1.addTask(task2);
    System.out.println(requirement1.countTasks());
    System.out.println(
        "Considering that all tasks belonging to the requirement are in ended state, is the requirement ended also? "
            + requirement1.isEnded());
    System.out.println(
        "Status of the requirement: " + requirement1.getStatus()); // Ended
    assertEquals("Ended", requirement1.getStatus());

  }
}