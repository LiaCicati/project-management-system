package Model;

import java.util.InputMismatchException;
import java.util.Objects;


/**
 * @version v.2 7th December 2020
 */

public class MyDate
{
  private int day;
  private int month;
  private int year;

  /**
   * Constructor for the date
   *
   * @param day   the day
   * @param month the month
   * @param year  the year
   */
  public MyDate(int day, int month, int year)
  {
    try
    {
      this.day = day;
      this.month = month;
      this.year = year;
    }
    catch (InputMismatchException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Getter for the day
   *
   * @return the day
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Getter for the month
   *
   * @return the month
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Getter for the year
   *
   * @return the year
   */
  public int getYear()
  {
    return year;
  }

  /**
   * A boolean method checking if it's a leap year
   *
   * @return true if it is a leap year and false if not
   */
  public boolean isLeapYear()
  {
    return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
  }

  /**
   * Getting the number of days in a month
   *
   * @return the number of days
   */
  public int numberOfDaysInMonth()
  {
    switch (month)
    {
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        return 28;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  /**
   * Setting the deadline
   *
   * @param day   the day
   * @param month the month
   * @param year  the year
   */
  public void set(int day, int month, int year)
  {
    if (year < 0)
    {
      year = -year;
    }
    if (month < 1)
    {
      month = 1;
    }
    else if (month > 12)
    {
      month = 12;
    }
    this.year = year;
    this.month = month;
    if (day < 1)
    {
      day = 1;
    }
    else if (day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }

  /**
   * Getting the name of the month
   *
   * @return the month name
   */
  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        return "Error";
    }
  }

  /**
   * Getting the month number
   *
   * @param monthName the month name
   * @return the month number
   */
  public int convertToMonthNumber(String monthName)
  {
    switch (monthName)
    {
      case "January":
        return 1;
      case "February":
        return 2;
      case "March":
        return 3;
      case "April":
        return 4;
      case "May":
        return 5;
      case "June":
        return 6;
      case "July":
        return 7;
      case "August":
        return 8;
      case "September":
        return 9;
      case "October":
        return 10;
      case "November":
        return 11;
      case "December":
        return 12;
      default:
        return 1;
    }
  }

  /**
   * Creating a new instance of the class of current object
   * @return the new instance of MyDate object
   */
  public MyDate copy()
  {
    MyDate other = new MyDate(day, month, year);
    return other;
  }

  /**
   * Checking if two dates are the same
   * @param obj object to be compared to
   * @return a boolean indicating if two instances are similar
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other = (MyDate) obj;
    return day == other.day && month == other.month && year == other.year;
  }

  /**
   * Getting all the needed information about the created date
   * @return a string containing the date
   */
  public String toString()
  {
    String s = "";
    if (day < 10)
    {
      s += "0";
    }
    s += day + "/";
    if (month < 10)
    {
      s += "0";
    }
    s += month + "/" + year;
    return s;
  }
}
  
