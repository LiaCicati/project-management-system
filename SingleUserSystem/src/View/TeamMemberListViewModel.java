package View;

import Mediator.ProjectManagementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.*;

public class TeamMemberListViewModel
{
    private ObservableList<TeamMemberViewModel> list;
    private ProjectManagementModel model;
    private ViewState viewState;

    public TeamMemberListViewModel(ProjectManagementModel model,
        ViewState viewState)
    {
        this.model = model;
        this.list = FXCollections.observableArrayList();
        this.viewState = viewState;
        update();
    }

    public ObservableList<TeamMemberViewModel> getList()
    {
        return list;
    }

    public void update()
    {
        list.clear();
        for (int i = 0; i < model.getTeamMemberList(model.getAllProjects()
            .getProjectById(viewState.getSelectedProject())).getSize(); i++)
        {
            list.add(new TeamMemberViewModel(model.getTeamMemberList(
                model.getAllProjects()
                    .getProjectById(viewState.getSelectedProject())).get(i)));
        }
    }

    public void remove(TeamMember teamMember)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getNameProperty().equals(teamMember.getName())
                && list.get(i).getIdProperty().get() == teamMember.getId()
                && list.get(i).getRoleProperty().get()
                .equals(teamMember.getRole()))
            {
                list.remove(i);
                break;
            }
        }
    }

    public void add(TeamMember teamMember)
    {
        list.add(new TeamMemberViewModel(teamMember));
    }
}