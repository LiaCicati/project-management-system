//package Model;
//
///**
// * @version v.2 7th December 2020
// */
//public class NonFunctional extends Requirement
//{
//  private String description;
//
//  /**
//   *
//   * @param ID the id of the requirement
//   * @param estimatedTime the estimated time per completion of a requirement
//   * @param responsibleTeamMember the responsible team member for a requirement
//   * @param deadline the deadline for the requirement
//   * @param description the what description of the requirement
//   */
//  public NonFunctional(int ID, double estimatedTime,
//      TeamMember responsibleTeamMember, MyDate deadline, String description)
//  {
//    super(ID, estimatedTime, responsibleTeamMember, deadline);
//    setDescription(description);
//  }
//
//  /**
//   * Getting the what description of the requirement
//   * @return the description
//   */
//  public String getDescription()
//  {
//    return description;
//  }
//
//  /**
//   * Sets the what description of the requirement
//   * @param description the description
//   */
//  public void setDescription(String description)
//  {
//    this.description = description;
//  }
//
//  /**
//   * Getter for the type of the requirement
//   * @return the requirement's type
//   */
//  public String getType()
//  {
//    return "Non-Functional";
//  }
//
//  /**
//   * Getting the information about a non functional requirement
//   * @return a string with all needed information about the non functional requirement
//   */
//  @Override public String toString()
//  {
//    return super.toString() + "User story: " + description;
//  }
//}
