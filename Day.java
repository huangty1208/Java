/*
  File: Day.java

  Description: This program will prompt the user to enter the year, month, and day. This program will print out the day of the week for that date.

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/03/14

  Date Last Modified: 07/03/14

*/

// import classes 
import java.util.Calendar;
import java.text.SimpleDateFormat;        
import java.util.Scanner;


public class Day
{
  public static void main(String[] args){

    Scanner input = new Scanner(System.in); 
    // initial integers
    int c = 0;
    int a = 0;
    int b = 0;
    
    //  prompt the user to enter the year and then check whether the year is in the range specified
    do
    {
      System.out.print ("Enter year: ");
      c = input.nextInt();
    } while ((c < 1900) || (c > 2100));      
    
    // check if it is a leap year
    boolean isLeap = (c % 400 == 0) || ((c % 100 != 0) && (c % 4 == 0));
    
    //  prompt the user to enter the month and then check whether the month is in the range specified
    do
    {
      System.out.print ("Enter month: ");
      a = input.nextInt();
    } while ((a < 1) || (a > 12));      
    
    //  specify if the month only has 30 days
    boolean smallMonth = (a == 4) || (a == 6) || (a == 9 ) || (a == 11);
    
    //  prompt the user to enter the day and then check whether the day is in the range specified
    do
    {
      System.out.print ("Enter day: ");
      b = input.nextInt();
    } while (b < 1 || b > 31 || (smallMonth && b > 30 ) || (a==2 && isLeap && b > 29) || (a==2 && !isLeap && b >28 ));
   
    // get the current time to determine the tense of the verb in the final output
    String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());    
    
    int currentYear = Integer.parseInt(timeStamp.substring(0,4));
    int currentMonth = Integer.parseInt(timeStamp.substring(4,6));
    int currentDay = Integer.parseInt(timeStamp.substring(6));
    
    // determine if it's a future date 
    boolean isFuture = c > currentYear || (c==currentYear && ((a > currentMonth) ||(a == currentMonth && b > currentDay)));
    
    // make the adjustment of months and years so that Jan = 11 and Feb =12
    if (a == 1 || a ==2)
    {
    a = a + 10;
    c = c -1;
    }
    else
    {
    a = a-2;    
    }
    
    // compute the constants in Rev. Zeller's algorithm

    int d = c / 100;
    c = c % 100 ;
    int w = (13 * a - 1 ) / 5 ; 
    int x = c / 4 ;
    int y = d / 4 ;
    int z = w + x + y + b + c - 2 * d ; 
    int r = z % 7 ;
    r = (r + 7) % 7 ; //to care of negative values of r
    
    
    // interpret r as day of the week
    String day ="" ;
    
    switch (r)
    {
        case 0 : day = "Sunday"; break;
        case 1 : day = "Monday"; break;
        case 2 : day = "Tuesday"; break;
        case 3 : day = "Wednesday"; break;
        case 4 : day = "Thursday"; break;            
        case 5 : day = "Friday"; break;
        case 6 : day = "Saturday"; break;            
    }

    
    //print the output based on verb tense
    if (isFuture)
    {
    System.out.println("\nThat day will be "+ day +".");            
    }
    else
    {
    System.out.println("\nThat day was "+day+".");    
    }    
   
  } 
    
    
}
