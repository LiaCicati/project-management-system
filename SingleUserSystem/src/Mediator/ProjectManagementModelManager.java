package Mediator;

import Model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.ParserException;
import parser.XmlJsonParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectManagementModelManager implements ProjectManagementModel
{
    private ProjectList projectList;
    private TeamMemberList teamMemberList;
    private RequirementList requirementList;
    private TaskList taskList;

    /**
     * Constructor for modelManager
     *
     * @throws ParserException exception needed fir initProjectsFromFile method
     */
    public ProjectManagementModelManager() throws ParserException
    {
        this.projectList = new ProjectList();
        this.teamMemberList = new TeamMemberList();
        initProjectsFromFiles();//calls the method to load the .xml files
        createDummyData();
    }

    /**
     * method that finds and displays .xml files
     */
    private void initProjectsFromFiles()
    {
        ArrayList<String> xmlFileNames = new ArrayList<>();

        File folder = new File("./");//SingleUserSystem folder
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++)
        {
            String filename = listOfFiles[i].getName();
            if (filename.endsWith(".xml") || filename.endsWith(".XML"))
            {
                try
                {
                    projectList.addProject(getSingleProject(filename));
                }
                catch (ParserException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method to read from .xml file
     *
     * @param fileName name of the file to read
     * @return parsed version of .xml file
     * @throws ParserException       needed exception
     * @throws IllegalStateException
     */
    private Project getSingleProject(String fileName)
        throws ParserException, IllegalStateException
    {
        XmlJsonParser parser = new XmlJsonParser();
        return parser.fromXml(fileName, Project.class);
    }

    /**
     * Creating Dummy data
     */
    private void createDummyData()
    {
        Project project1 = new Project("Goldcar Rental Company",
            new MyDate(18, 12, 2020), 353,
            "Needs a reservation system to handle customers, vehicles and reservations.");
        Project project2 = new Project("IT Minds", new MyDate(23, 12, 2020),
            338,
            "Needs a project management system to handle tasks and time for their IT projects in order to increase the company’s productivity and not waste time on little tasks");
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
        project2.addRequirement(requirement1);
        project2.addRequirement(requirement2);
        project2.addTeamMember(teamMember1);

    }

    /**
     * Getter for a team member by name
     * @param name name of team member
     * @return team member with specified name
     */
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

    /**
     * adding a task to a requirement
     * @param requirementID id of requirement related to the task you wish to add
     * @param projectID id of project related to the requirement
     * @param task task to be added
     */
    @Override public void addTask(int requirementID, int projectID, Task task)
    {
        projectList.getProjectById(projectID).getAllRequirements()
            .getByID(requirementID).addTask(task);

    }

    /**
     * Adding a team member to a project
     * @param projectID id of project a team member will be added to
     * @param teamMember team member to be added
     */
    @Override public void addTeamMember(int projectID, TeamMember teamMember)
    {
        projectList.getProjectById(projectID).addTeamMember(teamMember);
    }

    /**
     * edit values for a team member
     * @param projectID id of project related to the team member
     * @param ID id of team member
     * @param teamMember team member to be edited
     * @param role role of team member
     */
    @Override public void editTeamMember(int projectID, int ID,
        TeamMember teamMember, String role)
    {
        projectList.getProjectById(projectID).getAllTeamMembers()
            .getTeamMemberById(ID).changeRole(role);
        projectList.getProjectById(projectID).getAllTeamMembers()
            .getTeamMemberById(ID)
            .editTeamMember(teamMember.getName(), teamMember.getId());
    }

    /**
     * removing a team member from a project
     * @param teamMember team member to be removed
     */
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

    /**
     * adding a task to a requirement
     * @param requirement requirement a task will be added to
     * @param task task to be added
     */
    @Override public void addTaskToRequirement(Requirement requirement,
        Task task)
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

    /**
     * removing a task from a requirement
     * @param requirement requirement related to the task
     * @param task task to be removed
     */
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

    /**
     * removing a team member from a task
     * @param task task related to the team member
     * @param teamMember team member to be removed
     */
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

    /**
     * adding a requirement to a project
     * @param projectID id of project the requirement will be added to
     * @param requirement requirement to be added
     */
    @Override public void addRequirement(int projectID, Requirement requirement)
    {
        projectList.getProjectById(projectID).addRequirement(requirement);
    }

    /**
     * removing a requirement from a project
     * @param project project related to the requirement
     * @param requirementID id of requirement to be removed
     */
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

    /**
     * adding a project to the list
     * @param project project to be added
     * @param title project title
     * @param ID customer id
     */
    @Override public void addProject(Project project, String title, int ID)
    {
        projectList.addProject(project);
    }

    /**
     * removing a project
     * @param project project to be removed
     */
    @Override public void removeProject(Project project)
    {
        projectList.removeProject(project);
    }

    /**
     * getter for all team members
     * @param project project you wish to get team members from
     * @return all team members for the specified project
     */
    @Override public TeamMemberList getAllTeamMembers(Project project)
    {
        return project.getAllTeamMembers();
    }

    /**
     * getter for all tasks
     * @param requirement requirement you wish to get all tasks from
     * @return all tasks from the specified requirement
     */
    @Override public TaskList getAllTasks(Requirement requirement)
    {
        return requirement.getAllTasks();
    }

    /**
     * getter for all requirements
     * @param project project you wish to get all requirements from
     * @return all requirements from specified project
     */
    @Override public RequirementList getAllRequirements(Project project)
    {
        return project.getAllRequirements();
    }

    /**
     * getter for all tasks
     * @param project project related to the tasks
     * @param requirement requirement related to the tasks
     * @return all tasks from related requirement and project
     */
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

    /**
     * getter for all team members
     * @param project project related to team members
     * @param requirement requirement related to team members
     * @param task task related to team members
     * @return all team members related to the specified project, requirement and task
     */
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

    /**
     *getter for all projects
     * @return all projects
     */
    @Override public ProjectList getAllProjects()
    {
        return projectList;
    }

    /**
     * getter for a project
     * @param title project title
     * @return project with specified title
     */
    @Override public Project getProject(String title)
    {
        return projectList.getProjectByTitle(title);
    }

    /**
     * reorder priority of requirements
     * @param project project related to requirements
     * @param position position you wish to swap
     * @param newPosition position you wish to swap to
     */
    @Override public void reorderRequirements(Project project, int position,
        int newPosition)
    {
        project.getAllRequirements().reorder(position, newPosition);
    }

    /**
     * getter for number of tasks
     * @param requirement requirement related to tasks
     * @return number of tasks for the requirement
     */
    @Override public int getNumberOfTasks(Requirement requirement)
    {
        return requirement.countTasks();
    }

    /**
     * getter for number of requirements
     * @param project project related to requirements
     * @return number of requirements for the project
     */
    @Override public int getNumberOfRequirements(Project project)
    {
        return project.getNumberOfRequirements();
    }

    /**
     * getter for number of projects
     * @return number of projects
     */
    @Override public int getNumberOfProjects()
    {
        return projectList.getNumberOfProjects();
    }

    /**
     * getter for team member
     * @param project project related to team member
     * @param index index you wish to get
     * @return team member at index
     */
    @Override public TeamMember get(Project project, int index)
    {
        return project.getAllTeamMembers().get(index);
    }

    /**
     * getter for team member by an id
     * @param ID id of team member
     * @return team member with specified id
     */
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

    /**
     * edit values for a task
     * @param task task to edit
     * @param taskID id of task
     * @param projectID project id related to task
     * @param requirementID requirement id related to task
     * @param status status of task
     */
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

    /**
     * edit values for a requirement
     * @param projectID project id related to requirement
     * @param ID requirement id
     * @param requirement requirement to edit
     * @param status requirement status
     */
    @Override public void editRequirement(int projectID, int ID,
        Requirement requirement, String status)
    {
        projectList.getProjectById(projectID).getAllRequirements().getByID(ID)
            .editRequirement(requirement.getID(), requirement.getUserStory(),
                requirement.getType(), requirement.getEstimatedTime(),
                requirement.getResponsibleTeamMember(),
                requirement.getDeadline());
        projectList.getProjectById(projectID).getAllRequirements().getByID(ID)
            .setStatus(status);
    }

    /**
     * change status of a project
     * @param project project
     * @param status status for project
     */
    @Override public void changeStatus(Project project, String status)
    {
        project.changeStatus(status);
    }

    /**
     * change role of team member
     * @param teamMember team member
     * @param role role of team member
     */
    @Override public void changeRole(TeamMember teamMember, String role)
    {
        teamMember.changeRole(role);
    }

    /**
     * edit values of a project
     * @param projectID id of project
     * @param title project title
     * @param customerID id of a projects customer
     * @param description project description
     * @param deadline project deadline
     * @param status project status
     */
    @Override public void editProject(int projectID, String title,
        int customerID, String description, MyDate deadline, String status)
    {
        projectList.getProjectById(projectID)
            .editProject(title, customerID, description, deadline);
        projectList.getProjectById(projectID).changeStatus(status);
    }

    /**
     * getter for a project
     * @param index index of projectList
     * @return the project at the given index
     */
    public Project getProject(int index)
    {
        return projectList.getProject(index);
    }

    /**
     * getter for team member
     * @param projectID project id related to team member
     * @param index index to get
     * @return team member at index
     */
    @Override public TeamMember getTeamMemberAtIndex(int projectID, int index)
    {
        return projectList.getProjectById(projectID)
            .getTeamMemberAtIndex(index);
    }

    /**
     * getter for a project
     * @param id project id
     * @return the project with specified id
     */
    @Override public Project getProjectByID(int id)
    {
        return projectList.getProjectById(id);
    }

    /**
     * getter for team members
     * @return all team members
     */
    @Override public TeamMemberList getTeamMembers()
    {
        return teamMemberList;
    }

    /**
     * getter for number of team members
     * @return number of team members
     */
    public int getNumberOfTeamMembers()
    {
        return teamMemberList.getSize();
    }

    /**
     * getter for all requirements
     * @return all requirements
     */
    public RequirementList getAllRequirements()
    {
        return requirementList;
    }

    /**
     * getter for all team members
     * @param project project related to team members
     * @return all team members for the specified project
     */
    public TeamMemberList getTeamMemberList(Project project)
    {
        return project.getAllTeamMembers();
    }

    /**
     * getter for a team member
     * @param projectID project id related to team members
     * @param requirementID requirement id related to team members
     * @param taskID task id related to team members
     * @param teamMemberID team member id
     * @return team member with given id
     */
    @Override public TeamMember getAllTeamMembers(int projectID,
        int requirementID, int taskID, int teamMemberID)
    {
        return projectList.getProjectById(projectID).getAllRequirements()
            .getByID(requirementID).getAllTasks().getTaskByID(taskID)
            .getAllTeamMembers().getTeamMemberById(teamMemberID);
    }

    /**
     * getter for a requirement
     * @param id requirement id
     * @return the requirement with given id
     */
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

    /**
     * add hours worked to a task
     * @param projectID id related to a project
     * @param requirementID reuirement id
     * @param taskID task id
     * @param teamMemberID team member id
     * @param hours hours worked
     */
    @Override public void addHours(int projectID, int requirementID, int taskID,
        int teamMemberID, double hours)
    {
        projectList.getProjectById(projectID).getAllRequirements()
            .getByID(requirementID).getAllTasks().getTaskByID(taskID)
            .getAllTeamMembers().getTeamMemberById(teamMemberID)
            .registerTime(hours,
                projectList.getProjectById(projectID).getAllRequirements()
                    .getByID(requirementID).getAllTasks().getTaskByID(taskID));
    }
}