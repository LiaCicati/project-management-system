package Model;

public enum Type
{
  FUNCTIONAL, NON_FUNCTIONAL, PROJECT_RELATED;

  public String getTypeOfRequirement()
  {
    switch (this)
    {
      case FUNCTIONAL:
        return "Functional";
      case NON_FUNCTIONAL:
        return "Non-Functional";
      case PROJECT_RELATED:
        return "Project Related";
      default:
        throw new IllegalStateException("Illegal type value");
    }
  }
}
