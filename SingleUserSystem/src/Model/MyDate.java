package Model;

import java.util.Objects;

public class MyDate
{
  private int day;
  private int month;
  private int year;

  public MyDate(int day,int month,int year)
  {
    this.day=day;
    this.month=month;
    this.year=year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public boolean isLeapYear()
  {
    return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
  }

  public int numberOfDaysinMonth()
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
    else if (day > numberOfDaysinMonth())
    {
      day = numberOfDaysinMonth();
    }
    this.day = day;
  }

  public String getMonthName()
  {
    String status = "";
    if (month == 1)
    {
      status = "January";
    }
    else if (month == 2)
    {
      status = "February";
    }
    else if (month == 3)
    {
      status = "March";
    }
    else if (month == 4)
    {
      status = "April";
    }
    else if (month == 5)
    {
      status = "May";
    }
    else if (month == 6)
    {
      status = "June";
    }
    else if (month == 7)
    {
      status = "July";
    }
    else if (month == 8)
    {
      status = "Augest";
    }
    else if (month == 9)
    {
      status = "September";
    }
    else if (month == 10)
    {
      status = "October";
    }
    else if (month == 11)
    {
      status = "November";
    }
    else
    {
      status = "December";
    }
    return status;
  }

  public MyDate copy()
  {
    MyDate other = new MyDate(day,month,year);
    return other;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other=(MyDate)obj;
    return day == other.day && month == other.month && year == other.year;
  }

  public String toString ()
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
  
  public int convertToMonthNumber(String monthName)
  {
      int status = 0;
      if (monthName == "January")
      {
        status = 1;
      }
      else if (monthName == "February")
      {
        status = 2;
      }
      else if (monthName == "March")
      {
        status = 3;
      }
      else if (monthName == "April")
      {
        status = 4;
      }
      else if (monthName == "May")
      {
        status = 5;
      }
      else if (monthName == "June")
      {
        status = 6;
      }
      else if (monthName == "July")
      {
        status = 7;
      }
      else if (monthName == "Augest")
      {
        status = 8;
      }
      else if (monthName == "September")
      {
        status = 9;
      }
      else if (monthName == "October")
      {
        status = 10;
      }
      else if (monthName == "November")
      {
        status = 11;
      }
      else
      {
        status = 12;
      }
      return status;
    }
}
