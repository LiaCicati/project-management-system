package Model;

public class Name
{
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName)
  {
    setName(firstName, lastName);
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  public String getFormalName()
  {
    return lastName + " " + firstName;
  }

  public void setName(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Name))
    {
      return false;
    }
    Name other = (Name) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName);
  }

  @Override public String toString()
  {
    return getFullName();
  }
}
