package Model;

public class TeamMember
{
  private int id;
  private Name name;

  public TeamMember(Name name, int id)
  {
    this.name = name;
    setId(id);
  }

  public Name getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }
  
  public void setName(Name name)
  {
    this.name=name;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeamMember))
    {
      return false;
    }
    TeamMember other = (TeamMember) obj;
    return id == other.id && name.equals(other.name);
  }

  public String toString()
  {
    return "ID: " + id + ", Full name: " + name;
  }
}
