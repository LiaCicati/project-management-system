package Model;

public class ProductOwner extends TeamMember
{

  public ProductOwner(Name name, int id)
  {
    super(name, id);
  }

  public String getRole()
  {
    return "Product Owner";
  }

}
