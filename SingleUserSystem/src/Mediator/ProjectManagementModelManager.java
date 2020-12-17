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

    public ProjectManagementModelManager() throws ParserException
    {
        this.projectList = new ProjectList();
        this.teamMemberList = new TeamMemberList();
        initProjectsFromFiles();//calls the method to load the .xml files
        //    createDummyData();
    }

    /**method that finds and displays .xml files
     *
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

                //throws needed for DOM parsing
//                catch (ParserConfigurationException e)
//                {
//                    e.printStackTrace();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//                catch (SAXException e)
//                {
//                    e.printStackTrace();
//                }
//                catch (TransformerConfigurationException e)
//                {
//                    e.printStackTrace();
//                }
            }
        }
    }

    /**Method to read from .xml file
     *
     * @param fileName name of the file to read
     * @return parsed version of .xml file
     * @throws ParserException needed exception
     * @throws IllegalStateException
     */
    private Project getSingleProject(String fileName) throws ParserException, IllegalStateException
    {
        XmlJsonParser parser = new XmlJsonParser();
        return parser.fromXml(fileName, Project.class);
    }

    //using DOM parser to read from .xml files (could not get the tasks to initialize properly)
//    private Project getSingleProject(String fileName)
//        throws ParserConfigurationException, IOException, SAXException,
//        TransformerConfigurationException
//    {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document doc = builder.parse(fileName);
//        Transformer transformer = TransformerFactory.newInstance()
//            .newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "no");
//
//        NodeList subNodes = doc.getElementsByTagName("Project").item(0)
//            .getChildNodes();
//
//        String nodeName = "";
//        String nodeContent = "";
//        String projectTitle = "";
//        String projectDescription = "";
//        int customerID = 0;
//        MyDate projectDeadline = null;
//        TeamMemberList teamMemberList = null;
//        RequirementList requirementList = null;
//        TaskList taskList = null;
//
//        //runs through all subNodes in a .xml file
//        for (int i = 0; i < subNodes.getLength(); i++)
//        {
//            Node child = subNodes.item(i);
//            nodeName = child.getNodeName();//nodeName is the names we look for in the .xml file
//            nodeContent = child.getTextContent();//nodeContent is the data we want to extract from t.xml files
//
//            switch (nodeName)
//            {
//                case "customerID":
//                    customerID = Integer.parseInt(nodeContent);
//                    break;
//                case "description":
//                    projectDescription = nodeContent;
//                    break;
//                case "title":
//                    projectTitle = nodeContent;
//                    break;
//                case "deadline":
//                    NodeList deadlineSubNodes = child.getChildNodes();
//                    int deadlineDay = 0,
//                        deadlineMonth = 0,
//                        deadlineYear = 0;
//                    for (int j = 0; j < deadlineSubNodes.getLength(); j++)//new loop to run though all subNodes since deadline is from diff class
//                    {
//                        //have to set new nodeName and nodeContent when going into another subNode
//                        nodeContent = deadlineSubNodes.item(j).getTextContent();
//                        nodeName = deadlineSubNodes.item(j).getNodeName();
//                        switch (nodeName)
//                        {
//                            case "day":
//                                deadlineDay = Integer.parseInt(nodeContent);
//                                break;
//                            case "month":
//                                deadlineMonth = Integer.parseInt(nodeContent);
//                                break;
//                            case "year":
//                                deadlineYear = Integer.parseInt(nodeContent);
//                                break;
//                        }
//                    }//TODO add validation!
//                    projectDeadline = new MyDate(deadlineDay, deadlineMonth,
//                        deadlineYear);
//                    break;
//                case "teamMemberList":
//                    NodeList teamMembersSubNodes = child.getChildNodes();
//                    teamMemberList = new TeamMemberList();
//                    Name teamMemberName = null;
//                    int teamMemberID = 0;
//                    String teamMemberRole = "";
//                    for (int j = 0; j < teamMembersSubNodes.getLength(); j++)//new loop to run though next set of subNodes
//                    {
//                        Node teamMemberNode = teamMembersSubNodes.item(j);
//                        if (!teamMemberNode.getNodeName().equals("teamMembers"))//breaks without this because of subNode hierarchy
//                            continue;
//
//                        for (int k = 0; k < teamMemberNode.getChildNodes()//new loop to run though next set of subNodes
//                            .getLength(); k++)
//                        {
//                            Node teamMemberDataNode = teamMemberNode
//                                .getChildNodes().item(k);
//                            nodeContent = teamMemberDataNode.getTextContent();
//                            nodeName = teamMemberDataNode.getNodeName();
//
//                            switch (nodeName)
//                            {
//                                case "name":
//                                    NodeList nameSubNodes = teamMemberDataNode
//                                        .getChildNodes();
//                                    String firstName = "";
//                                    String lastName = "";
//                                    for (int l = 0;
//                                         l < nameSubNodes.getLength(); l++)//new loop to run though next set of subNodes
//                                    {
//                                        Node nameNode = nameSubNodes.item(l);
//                                        nodeContent = nameNode.getTextContent();
//                                        nodeName = nameNode.getNodeName();
//                                        switch (nodeName)
//                                        {
//                                            case "firstName":
//                                                firstName = nodeContent;
//                                                break;
//                                            case "lastName":
//                                                lastName = nodeContent;
//                                                break;
//                                        }
//                                    }//TODO add validation!
//                                    teamMemberName = new Name(firstName,
//                                        lastName);
//                                    break;
//                                case "id":
//                                    teamMemberID = Integer
//                                        .parseInt(nodeContent);
//                                    break;
//                                case "role":
//                                    teamMemberRole = nodeContent;
//                                    break;
//                            }
//                        }//TODO ask about team member types!
//                        teamMemberList.addTeamMember(
//                            new TeamMember(teamMemberName, teamMemberID));
//                        teamMemberList.getTeamMemberById(teamMemberID).changeRole(teamMemberRole);
//                    }
//                    break;
//                    //TODO implement cases for the remaining subNodes!
//                case "requirementList":
//                    NodeList requirementsSubNodes = child.getChildNodes();
//                    requirementList = new RequirementList();
//                    double estimatedTime = 0;
//                    TeamMember responsibleTeamMember = null;
//                    double timeSpent = 0;
//                    String userStory = "";
//                    String requirementStatus = "";
//                    int requirementID = 0;
//                    Type type = null;
//                    MyDate requirementDeadline = null;
//                    Requirement temp = null;
//
//                    for (int j = 0; j < requirementsSubNodes.getLength(); j++)
//                    {
//                        Node requirementNode = requirementsSubNodes.item(j);
//                        if (!requirementNode.getNodeName().equals("requirements"))//breaks without this because of subNode hierarchy
//                            continue;
//
//                        for (int k = 0; k < requirementNode.getChildNodes()
//                            .getLength(); k++)
//                        {
//                            Node requirementDataNode = requirementNode
//                                .getChildNodes().item(k);
//                            nodeContent = requirementDataNode.getTextContent();
//                            nodeName = requirementDataNode.getNodeName();
//
//                            switch (nodeName)
//                            {
//                                case "estimatedTime":
//                                    estimatedTime = Double.parseDouble(nodeContent);
//                                    break;
//                                case "timeSpent":
//                                    timeSpent = Double.parseDouble(nodeContent);
//                                    break;
//                                case "userStory":
//                                    userStory = nodeContent;
//                                    break;
//                                case "ID":
//                                    requirementID = Integer.parseInt(nodeContent);
//                                    break;
//                                case "type":
//                                    type = Type.valueOf(nodeContent);
//                                    break;
//                                case "status":
//                                    requirementStatus = nodeContent;
//                                    break;
//                                case "responsibleTeamMember":
//                                    NodeList teamMemberSubNodes = requirementDataNode.getChildNodes();
//                                    String role = "";
//                                    int ID = 0;
//                                    Name name = null;
//
//                                    for (int l = 0; l < teamMemberSubNodes.getLength(); l++)
//                                    {
//                                        Node teamMemberNode = teamMemberSubNodes.item(l);
//                                        nodeContent = teamMemberNode.getTextContent();
//                                        nodeName = teamMemberNode.getNodeName();
//                                        switch (nodeName)
//                                        {
//                                            case "role":
//                                                role = nodeContent;
//                                                break;
//                                            case "id":
//                                                ID = Integer.parseInt(nodeContent);
//                                                break;
//                                            case "name":
//                                                NodeList nameSubNodes = teamMemberNode.getChildNodes();
//                                                String responsibleFirstName = "";
//                                                String responsibleLastName = "";
//                                                for (int m = 0; m < nameSubNodes.getLength(); m++)
//                                                {
//                                                    Node nameNode = nameSubNodes.item(m);
//                                                    nodeContent = nameNode.getTextContent();
//                                                    nodeName = nameNode.getNodeName();
//                                                    switch (nodeName)
//                                                    {
//                                                        case "firstName":
//                                                            responsibleFirstName = nodeContent;
//                                                            break;
//                                                        case "lastName":
//                                                            responsibleLastName = nodeContent;
//                                                            break;
//                                                    }
//                                                }
//                                                name = new Name(responsibleFirstName, responsibleLastName);
//                                                break;
//                                        }
//                                    }
//                                    responsibleTeamMember = new TeamMember(name, ID);
//                                    responsibleTeamMember.changeRole(role);
//                                    break;
//                                case "deadline":
//                                    NodeList requirementDeadlineSubNodes = requirementDataNode.getChildNodes();
//                                    int requirementDeadlineDay = 0,
//                                        requirementDeadlineMonth = 0,
//                                        requirementDeadlineYear = 0;
//                                    for (int l = 0; l < requirementDeadlineSubNodes.getLength(); l++)//new loop to run though all subNodes since deadline is from diff class
//                                    {
//                                        //have to set new nodeName and nodeContent when going into another subNode
//                                        nodeContent = requirementDeadlineSubNodes.item(l).getTextContent();
//                                        nodeName = requirementDeadlineSubNodes.item(l).getNodeName();
//                                        switch (nodeName)
//                                        {
//                                            case "day":
//                                                requirementDeadlineDay = Integer.parseInt(nodeContent);
//                                                break;
//                                            case "month":
//                                                requirementDeadlineMonth = Integer.parseInt(nodeContent);
//                                                break;
//                                            case "year":
//                                                requirementDeadlineYear = Integer.parseInt(nodeContent);
//                                                break;
//                                        }
//                                    }//TODO add validation!
//                                    requirementDeadline = new MyDate(requirementDeadlineDay, requirementDeadlineMonth,
//                                        requirementDeadlineYear);
//                                    break;
//                                case "tasks":
//                                    NodeList tasksSubNodes = requirementDataNode.getChildNodes();
//                                    taskList = new TaskList();
//                                    double taskEstimatedTime = 0,
//                                        taskTimeSpent = 0;
//                                    int taskID = 0,
//                                        taskRequirementID = 0;
//                                    String taskDescription = "",
//                                        taskTitle = "",
//                                        taskStatus = "";
//                                    TeamMember taskResponsibleTeamMember = null;
//                                    MyDate taskDeadline = null;
////                                    Requirement temp = null;
////                                    temp.setStatus(requirementStatus);
////                                    temp.setTimeSpent(timeSpent);
//
//                                    for (int l = 0; l < tasksSubNodes.getLength(); l++)
//                                    {
//                                        Node taskNode = tasksSubNodes.item(l);
//                                        if (!taskNode.getNodeName().equals("tasks"))//breaks without this because of subNode hierarchy
//                                            continue;
//
//                                        for (int m = 0; m < taskNode.getChildNodes().getLength(); m++)
//                                        {
//                                            Node taskDataNode = taskNode
//                                                .getChildNodes().item(m);
//                                            nodeContent = taskDataNode.getTextContent();
//                                            nodeName = taskDataNode.getNodeName();
//
//                                            switch (nodeName)
//                                            {
//                                                case "estimatedTime":
//                                                    taskEstimatedTime = Double.parseDouble(nodeContent);
//                                                    break;
//                                                case "timeSpent":
//                                                    taskTimeSpent = Double.parseDouble(nodeContent);
//                                                    break;
//                                                case "description":
//                                                    taskDescription = nodeContent;
//                                                    break;
//                                                case "ID":
//                                                    taskID = Integer.parseInt(nodeContent);
//                                                    break;
//                                                case "title":
//                                                    taskTitle = nodeContent;
//                                                    break;
//                                                case "requirementID":
//                                                    taskRequirementID = Integer.parseInt(nodeContent);
//                                                    break;
//                                                case "status":
//                                                    taskStatus = nodeContent;
//                                                    break;
//                                                case "responsibleTeamMember":
//                                                    NodeList taskTeamMemberSubNodes = taskDataNode.getChildNodes();
//                                                    String taskMemberRole = "";
//                                                    int taskMemberID = 0;
//                                                    Name taskMemberName = null;
//
//                                                    for (int n = 0; n < taskTeamMemberSubNodes.getLength(); n++)
//                                                    {
//                                                        Node taskTeamMemberNode = taskTeamMemberSubNodes.item(l);
//                                                        nodeContent = taskTeamMemberNode.getTextContent();
//                                                        nodeName = taskTeamMemberNode.getNodeName();
//                                                        switch (nodeName)
//                                                        {
//                                                            case "role":
//                                                                taskMemberRole = nodeContent;
//                                                                break;
//                                                            case "id":
//                                                                taskMemberID = Integer.parseInt(nodeContent);
//                                                                break;
//                                                            case "name":
//                                                                NodeList nameSubNodes = taskTeamMemberNode.getChildNodes();
//                                                                String taskFirstName = "";
//                                                                String taskLastName = "";
//                                                                for (int t = 0; t < nameSubNodes.getLength(); t++)
//                                                                {
//                                                                    Node nameNode = nameSubNodes.item(t);
//                                                                    nodeContent = nameNode.getTextContent();
//                                                                    nodeName = nameNode.getNodeName();
//                                                                    switch (nodeName)
//                                                                    {
//                                                                        case "firstName":
//                                                                            taskFirstName = nodeContent;
//                                                                            break;
//                                                                        case "lastName":
//                                                                            taskLastName = nodeContent;
//                                                                            break;
//                                                                    }
//                                                                }
//                                                                taskMemberName = new Name(taskFirstName, taskLastName);
//                                                                break;
//                                                            case "deadline":
//                                                                NodeList taskDeadlineSubNodes = taskDataNode.getChildNodes();
//                                                                int taskDeadlineDay = 0,
//                                                                    taskDeadlineMonth = 0,
//                                                                    taskDeadlineYear = 0;
//
//                                                                for (int o = 0; o < taskDeadlineSubNodes.getLength(); o++)
//                                                                {
//                                                                    nodeContent = taskDeadlineSubNodes.item(o).getTextContent();
//                                                                    nodeName = taskDeadlineSubNodes.item(o).getNodeName();
//                                                                    switch (nodeName)
//                                                                    {
//                                                                        case "day":
//                                                                            taskDeadlineDay = Integer.parseInt(nodeContent);
//                                                                            break;
//                                                                        case "month":
//                                                                            taskDeadlineMonth = Integer.parseInt(nodeContent);
//                                                                            break;
//                                                                        case "year":
//                                                                            taskDeadlineYear = Integer.parseInt(nodeContent);
//                                                                            break;
//                                                                    }
//                                                                }//TODO add validation!
//                                                                taskDeadline = new MyDate(taskDeadlineDay, taskDeadlineMonth,
//                                                                    taskDeadlineYear);
//                                                                break;
//                                                        }
//                                                    }
//                                                    taskResponsibleTeamMember = new TeamMember(taskMemberName, taskMemberID);
//                                                    taskResponsibleTeamMember.changeRole(taskMemberRole);
//                                                    break;
//                                            }
//                                        }
//                                        taskList.addTask(new Task(temp, taskID, taskTitle, taskDescription, taskEstimatedTime, taskResponsibleTeamMember, taskDeadline));
//                                        taskList.getTaskByID(taskID).setStatus(taskStatus);
//                                        taskList.getTaskByID(taskID).setTimeSpent(taskTimeSpent);
//                                    }
//                                    break;
//                            }
//                        }
//                        requirementList.addRequirement(new Requirement(requirementID, userStory, type, estimatedTime, responsibleTeamMember, requirementDeadline));
//                        requirementList.getByID(requirementID).setStatus(requirementStatus);
//                        requirementList.getByID(requirementID).setTimeSpent(timeSpent);
//                        requirementList.getByID(requirementID).setTaskList(taskList);
//                    }
//                    break;
//            }
//        }
//        Project p = new Project(projectTitle, projectDeadline, customerID,
//            projectDescription);
//        p.setTeamMemberList(teamMemberList);
//        p.setRequirementList(requirementList);
//        return p;
//    }

    //  private void createDummyData()
    //  {
    //    Project project1 = new Project("Goldcar Rental Company", new MyDate(18, 12, 2020),
    //        35, "Needs a reservation system to handle customers, vehicles and reservations.");
    //    Project project2 = new Project("IT Minds", new MyDate(23, 12, 2020),
    //        38, "Needs a project management system to handle tasks and time for their IT projects in order to increase the company’s productivity and not waste time on little tasks");
    //    projectList.addProject(project1);
    //    projectList.addProject(project2);
    //
    //    Name name1 = new Name("Bob", "Turquoise");
    //    Name name2 = new Name("Evan", "Peters");
    //    TeamMember teamMember1 = new TeamMember(name1, 244);
    //    TeamMember teamMember2 = new TeamMember(name2, 128);
    //
    //    project1.addTeamMember(teamMember1);
    //    project1.addTeamMember(teamMember2);
    //    Requirement requirement1 = new Requirement(33,
    //        "As a customer I want access to a website", Type.FUNCTIONAL, 25,
    //        teamMember1, new MyDate(25, 12, 2020));
    //    Requirement requirement2 = new Requirement(46,
    //        "As a customer I want access to a website", Type.FUNCTIONAL, 30,
    //        teamMember2, new MyDate(28, 12, 2020));
    //    project1.addRequirement(requirement1);
    //    project1.addRequirement(requirement2);
    //
    //    Task task1 = new Task(requirement1, 2, "To do", "some text", 15.5,
    //        teamMember1, new MyDate(3, 1, 2021));
    //    requirement1.addTask(task1);
    //    requirement1.addTeamMember(teamMember1);
    //    requirement1.addTeamMember(teamMember2);
    //    teamMember1.registerTime(25, task1);
    //    project2.addRequirement(requirement1);
    //    project2.addRequirement(requirement2);
    //    project2.addTeamMember(teamMember1);
    //
    //
    //  }

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
                requirement.getResponsibleTeamMember(),
                requirement.getDeadline());
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

    @Override public void editProject(int projectID, String title,
        int customerID, String description, MyDate deadline, String status)
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
        return projectList.getProjectById(projectID)
            .getTeamMemberAtIndex(index);
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
            .getAllTeamMembers().getTeamMemberById(teamMemberID)
            .registerTime(hours,
                projectList.getProjectById(projectID).getAllRequirements()
                    .getByID(requirementID).getAllTasks().getTaskByID(taskID));
    }
}