package Model;

/**
 * @version v.2 7th December
 */
public class ProductOwner extends TeamMember
{
  /**
   * Constructor for the product owner
   * @param name the name of the product owner
   * @param id the id of the product owner
   */
  public ProductOwner(Name name, int id)
  {
    super(name, id);
  }

  /**
   * Getter for the role of the team member
   * @return the role
   */
  public String getRole()
  {
    return "Product Owner";
  }

}
