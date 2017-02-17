
/*
  File: CalculatePI.java

  Description: This program will experiment and see if the accuracy of PI increases with the number of throws on the dartboard.
  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/21/14

  Date Last Modified: 07/21/14

*/

// import all classes yto use random
import java.util.*;

public class CalculatePI
{
  // define the isInside() method to determine if the random point is within the circle  
  public static boolean isInside ( double xPos, double yPos )
  {
    //  if a point is inside the circle its distance from the center of the circle must be less than the radius of the circle.  
    double distance = Math.sqrt ( xPos * xPos + yPos * yPos );
    if(distance <1)
      return true ; 
    else
      return false;
  }   
  // define the computePI() method to estimate the value of PI
  public static double computePI ( int numThrows )
  { 
    // create a Random object called randomGen. read the time from the System clock and use that as our seed.  
    Random randomGen = new Random ( System.currentTimeMillis() );   
    double xPos ;
    double yPos ;      
  
    int count = 0;
    //simulate throwing the dart with the times given 
    for (int i =1; i <= numThrows; i++ )
    {  
      xPos = (randomGen.nextDouble()) * 2 - 1.0;
      yPos = (randomGen.nextDouble()) * 2 - 1.0;         
      if(isInside ( xPos, yPos ))  
      {
      // increment if the point is within the circle    
      count +=1 ;
      }    
    }
    double pi = ((double)count / (double)numThrows) *4 ; 
    // return calculated PI value 
    return pi;
  
  }

  public static void main ( String[] args )
  {
    double pi = Math.PI; 
    int i =100;
    System.out.println("Computation of PI using Random Numbers"+"\n") ;
    // experiment and see if the accuracy of PI increases with the number of throws on the dartboard.
    while(i<=100000)
    {       
      double calPI = computePI (i);   
      // compare your result with the value given by Math.PI.
      System.out.printf("Number of throws = "+i+ ", Computed PI = %8f" + ", Difference = "+(calPI-pi)+"\n", calPI);
      i=i*10;
    }
  
    System.out.println ("\n"+"* Difference = Computed PI - Math.PI") ;   
  } 

   
}