/*
  File: FibonacciBase.java

  Description: This program will take as input a decimal integer and returns a String representation of the binary number in the Fibonacci base.

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/30/14

  Date Last Modified: 07/30/14

*/

// import Scanner class
import java.util.Scanner;

public class FibonacciBase
{

  public static String convert (int num)   
  {
    // define the first three numbers of fibonacci sequence 
    int f0 = 0;
    int f1 = 1;
    int f2 =0 ;
    
    // count the numbers to determine the size of the array 
    int count = 0;
     
    // iterate to find which fibonacci number is bigger than the input number 
    while(f2<=num)
    {
      f2=f1+f0;
      f0=f1;
      f1=f2;
      count+=1;
    }      
   
    // define the fibonacci array 
    int [] fibArray = new int[count-1];   
    f0=0;
    f1=1;
    f2=1;
    
    // reverse the count so the biggest fibonacci number is the first number in that array 
    for(int i = count-2;i>=0;i--)
    {
      fibArray[i]=f2;
      f0=f1;
      f1=f2;
      f2=f1+f0;
    }    
   
    // define another array to record which number is used to get the desired number
    int[] fibCount = new int[count-1];
    int c = 0;
 
    while(num!=0)
    {
      // start from the first fib number from the array to iterate through each element of the array to substract the number untill it's zero  
      if(num>=fibArray[c])
      {
        num=num-fibArray[c];
      // record the number used  
        fibCount[c]+=1;
        c++;
      }    
      else
      {
        c++;
      }  
    }    
    // use a string to represent all the counts of each fib number
    String result = "";
    for(int e:fibCount)
    {
      result+=e;    
    }    
    // return the result
    return result;   
 }        

 public static void main (String[] args)
 {
   // Create Scanner object
   Scanner input = new Scanner(System.in); 

   // Prompt user to enter a decimal integer
   System.out.print("Enter a decimal integer: ");

   // Test if the input is a decimal integer 
   if(!input.hasNextInt())
   {
     // If not print error message and exit program    
     System.out.println("\n"+"Error, please enter a positive integer less than one million: "); 
     System.exit(0);
   }    
    
   int num = input.nextInt();
    
   // Test if the input is less than one million    
   if(num<=0 || num >= 1000000 )
   {
     System.out.println("\n"+"Error, please enter a positive integer less than one million: "); 
     System.exit(0);    
   }    

   // Get the String representation of the decimal number
   System.out.println("\n"+num+" = "+convert(num)+" (fib)");

  } 
  
}
