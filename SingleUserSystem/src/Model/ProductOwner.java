package Model;
public class ProductOwner
{
  private Name name;
  private int id;

  public ProductOwner(Name name,int id)
  {
    this.name=name;
    this.id=id;
  }

  public String getRole()
  {
    return "Product Owner";
  }

}
