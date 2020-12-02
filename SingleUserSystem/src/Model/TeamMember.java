import java.util.Objects;

public class TeamMember
{
  private int id;
  private String role;
  private Name name;

  public TeamMember(Name name,String role,int id)
  {
    this.name=name;
    this.role=role;
    this.id=id;
  }

  public Name getName()
  {
    return name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof TeamMember))
    {
      return false;
    }
    TeamMember other=(TeamMember)obj;
    return id == other.id && name == other.name && role == other.role;
  }

  public String toString()
  {
    return "TeamMember{" + "id=" + id + ", role='" + role + '\'' + ", name="
        + name + '}';
  }

  }
