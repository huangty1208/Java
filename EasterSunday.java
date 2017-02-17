
/*
  File: EasterSunday.java

  Description: This program will will compute the date of Easter Sunday

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 06/22/14

  Date Last Modified: 06/22/14 

*/
import java.util.Scanner;

public class EasterSunday
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in); 
    System.out.print("Enter year: ");
    int year = input.nextInt();
    int a = year % 19;
    int b = year / 100;
    int c = year % 100;
    int d = b / 4;
    int e = b % 4;
    int g = (8 * b + 13) / 25;
    int h = (19 * a + b - d - g + 15) % 30;  
    int j = c / 4;
    int k = c % 4;
    int m = (a + 11 * h) / 319;    
    int r = (2 * e + 2 * j - k - h + m + 32) % 7;
    int n = (h - m + r + 90) / 25;
    int p = (h - m + r + n + 19) % 32;
   
    String month ="";
    
    if (n==1)
    {
      month = "January";
    }
    else if (n==2)
    {
      month = "February";
    }
    else if (n==3)
    {
      month = "March";
    }
    else if (n==4)
    {
      month = "April";
    }
    else if (n==5)
    {
      month = "May";
    }
    else if (n==6)
    {  
      month = "June";
    }
    else if (n==7)
    {  
      month = "July";
    }
    else if (n==8)
    {  
      month = "August";
    }
    else if (n==9)
    {  
      month = "September";
    }
    else if (n==10)
    {  
      month = "October";
    }
    else if (n==11)
    {  
      month = "November";
    }
    else if (n==12)
    {  
      month = "December";
    }
    
    System.out.println("In "+year+", Easter Sunday is on "+p+" "+month+"."); 
  }
    
}
