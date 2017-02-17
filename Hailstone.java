
/*
  File: Hailstone.java

  Description: This program will verify the Hailstone conjecture in a user defined range.

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/08/14

  Date Last Modified: 07/08/14

*/

// import scanner class
import java.util.Scanner;

public class Hailstone
{
  public static void main(String[] args){

    // prompt user to enter the starting number of the range and the ending number    
    System.out.print("Enter starting and ending number of the range: ");    
    Scanner input = new Scanner(System.in); 
    int start = input.nextInt();
    int end = input.nextInt();

    //check if both numbers are positive (> 0) individually and check that the starting number  is strictly less than the ending number 
    
    while(start <=0 || end <=0 || start >= end)
    {
      System.out.print("Enter starting and ending number of the range: "); 
      start = input.nextInt();
      end = input.nextInt();    
    }    
    
    //initiate integers for max cycle and number
    int maxCycle = 0;
    int maxNum = 1;
    
    
    // compute the cycle length for each of the numbers in that range inclusive of the end points
    for(int i = start; i <= end;i++)
    {
      int count =0;  
      int k =i;

      while(k!=1)
      {
        if(k % 2 == 0)
        {
          k = k / 2;
          count+=1;
        }       
        else
        {
          k = 3*k + 1; 
          count+=1;
        }   
            
      } 
      if (count>maxCycle)
      {
        maxCycle = count ;
        maxNum = i ;
      }      
    }
    
    //print out the number that has the largest cycle length and what that cycle length is

    System.out.println("\n"+"The number "+maxNum+" has the longest cycle length of "+maxCycle+".");

  } 
     
}
