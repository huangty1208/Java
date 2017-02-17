/*
  File: Spiral.java

  Description: This program will read input from the file spiral.txt and write the neigboring numbers of the second number in three lines.

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 08/04/14

  Date Last Modified: 08/04/14

*/

// import Scanner class
import java.util.Scanner;
import java.io.*;

public class Spiral
{ 
  public static void main (String[] args) throws IOException
  {
    // create new file project to read input from spiral.txt 
    File infile = new File("spiral.txt") ;  
    Scanner input = new Scanner(infile);
   
    // save the numbers
    int dimension = input.nextInt();
    int target = input.nextInt();     
    
    // initiate the row and column to save the location of the taget number 
    int row = 0 ;
    int col = 0 ;
   
    if(dimension<=1)
    {
      System.out.println("No neigboring numbers");
    }    
    //  If the second number is not in that range, print an error message Number not in Range.
    else if(target <1 || target> dimension*dimension)
    {
      System.out.println("Number not in Range");
    }    
    else
    { 
      // This number should be an odd number. If it is not then choose the dimension to be the next higher odd number  
      if(dimension % 2 ==0 )
      dimension=dimension+1;    
      
      // call spiral function to get the spiral table as a 2D array
      int [][] result = spiral(dimension); 
      
      // iterate to find the target number
      for(int i =0;i <result.length;i++)
      {    
        for(int k =0;k < result[0].length;k++)
        {
          if(result[i][k]==target)  
          {
            // save the location of the target number  
            row = i;
            col = k;
            break ;
          }  
        }    
      } 
      //  if that second number was on the outer edge of the spiral then print Number on Outer Edge.
      if(row==0 || row == dimension-1 || col == 0 || col == dimension-1 )
      {
        System.out.println("Number on Outer Edge");
      }
      else
      {
        // write the neigboring numbers of the second number in three lines.  
        System.out.print("\n"+result[row-1][col-1]+" "+result[row-1][col]+" "+result[row-1][col+1]+"\n");
        System.out.print(""+result[row][col-1]+" "+result[row][col]+" "+result[row][col+1]+"\n");
        System.out.print(""+result[row+1][col-1]+" "+result[row+1][col]+" "+result[row+1][col+1]+"\n");   
      }
    }
 }        
         
         
   // define the spiral function to get the spiral table based on the given dimension      
   public static int[][] spiral(int num)        
   {
     // create a new 2d array
     int[][] spiral = new int[num][num];
    
     // use d to represent the column and row numbers of the 1 in the middle of the array
     int d =(num-1)/2;
 
     int x = 0;
     
     // initiate three temperary numbers to store the diagonal numbers in each row starting from 1 
     int tem = 0 ;
     int tem2 = 0 ;
     int tem3 = 0 ;
 
     // iterate from the smallest square to the biggest 
     for (int j = 1; j<=num;j=j+2)
     {
       x = 0;     
       // get the Partial sums of the nature number
       for (int i =1; i<=(j-1)/2;i++)
       {
         x=x+i;
       }    
       // get the up left diagonal number of each rowstarting from 1 in the middle
       tem = 1 + 8*x-((j-1)/2)*2 ;
 
       spiral[d][d]= tem;
       
       // use that number to get the other numbers in the same row and column and save them in the array
       for(int k =1;k<j;k++)
       {
         spiral[d][d+k]=tem+k;
         spiral[d+k][d]=tem-k;
 
       }    
       // get the down left diagonal number
       tem2 = spiral[d+j-1][d];
       for(int m =1;m<j;m++)
       {
         // based on the down left number to get the numbers in the same row
         spiral[d+j-1][d+m]=tem2-m;
       }  
       // get the down right diagonal number
       tem3 = spiral[d+j-1][d+j-1];
       for(int n = 1;n<j-1;n++)
       {
         // based on that number to get numbers in the same column and save them in the array
         spiral[d+j-1-n][d+j-1]=tem3-n;
       }    
       
       // go to the outer square 
       d--;
     }
     
     // return the array
     return spiral; 
   }
  
}
