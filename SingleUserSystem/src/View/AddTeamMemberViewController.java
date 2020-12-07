//package View;
//
//import Mediator.ProjectManagementModel;
//import javafx.fxml.FXML;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Region;
//import Model.TeamMember;
//
//public class AddTeamMemberViewController
//{
//  @FXML private  TextField nameTextField;
//  @FXML private ChoiceBox roleCbx;
//  @FXML private Label errorLabel;
//  private Region root;
//  private ViewHandler viewHandler;
//  private ProjectManagementModel model;
//
//  public AddTeamMemberViewController(){}
//  public void init(ViewHandler viewHandler, ProjectManagementModel model,Region root)
//  {
//    this.viewHandler=viewHandler;
//    this.model=model;
//    this.root=root;
//    reset();
//  }
//
//  public void reset()
//  {
//    nameTextField.setText("");
//    roleCbx.setItems(null);
//  }
//
//  public Region getRoot(){return root;}
//  @FXML private void SaveDataButton()
//  {
//    try
//    {
//      TeamMember teamMember1 = new TeamMember(nameTextField.getText(), roleCbx.getSelectionModel() // type Problem
//          .getSelectedIndex());
//      model.addTeamMember(teamMember1);
//      viewHandler.closeView();
//      viewHandler.openView("TeamMemberView");
//    }
//    catch (Exception e)
//    {
//      errorLabel.setText(e.getMessage());
//    }
//  }
//  @FXML private  void addTeamMemberCancelButton()
//  {
//    viewHandler.closeView();
//    viewHandler.openView("TeamMemberListView");
//  }
//}
