package Model;

/**
 * @version v.2 7th December 2020
 */
public class Name
{
  private String firstName;
  private String lastName;

  /**
   * Constructor for the name of a team member
   * @param firstName the first name of team member
   * @param lastName the last name of team member
   */
  public Name(String firstName, String lastName)
  {
    setName(firstName, lastName);
  }

  /**
   * Getter for the first name of a team member
   * @return the first name
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Getter for the last name of a team member
   * @return the last name
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Getter for the full name of a team member
   * @return the full name
   */
  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  /**
   * Getter for the formal name of a team member
   * @return the formal name
   */
  public String getFormalName()
  {
    return lastName + " " + firstName;
  }

  /**
   * Setter for the name of a team member
   * @param firstName the first name
   * @param lastName the last time
   */
  public void setName(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Checking if two names are the same
   * @param obj object to be compared to
   * @return a boolean indicating if two instances are similar
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Name))
    {
      return false;
    }
    Name other = (Name) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName);
  }

  /**
   * Getting the team member's name
   * @return a string returning the full name of a team member
   */
  @Override public String toString()
  {
    return getFullName();
  }
}
