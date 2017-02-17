
/*
  File: DNA.java

  Description: This program will will open a text file called dna.txt and find the longest common base sequence in two DNA strands.
  
  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/26/14

  Date Last Modified: 07/26/14

*/

// // import Scanner and file classes 

import java.util.*;
import java.io.*;

public class DNA
{
  public static void main(String args[]) throws Exception
  {
      
    // Creating a Handle to a File
    File infile = new File("dna.txt");   
    //  text file can be read using a Scanner object.
    Scanner input = new Scanner(infile);
    // store the integer number that gives the number of pairs of DNA to follow. 
    int setNum = Integer.parseInt(input.nextLine());
  
    System.out.println("Longest Common Sequences");
    System.out.println("\n");
  
    // iterate through each pair
    for(int i =0; i< setNum ; i++)
    {
      System.out.print("Pair "+ (i+1) +": ");    
  
      // store two sequences as two strings
      String s1 = input.nextLine();
      String s2 = input.nextLine(); 
 
      // initiate common sequence count and sequence window size 
      int count = 0 ;
      int wnd = s1.length();
  
      // a sequence of 1 base does not count
      while (wnd>1)
      {
        count = 0;    
        int index = 0;
  
        // generate sub-sequences from the sequence 1 and save it as temp
        while (index+wnd<=s1.length())
        {
          String temp = s1.substring(index,index+wnd);
  
          // if sequence 2 has the same sequence, print it out 
          if(s2.contains(temp)&& count==0)
          {
            System.out.println(temp);    
            count+=1;
          }
          // print more common sequences that have the same longest length.
          else if(s2.contains(temp))
          {
            System.out.println("        "+temp);    
            count+=1;    
          }
          index++;
        }
  
        // if found, stop the iteration
        if(count>=1)
        {    
          break;
        }
  
        // decrease the window size
        wnd--;
      }
  
      // If there is no common sequence your program should output No Common Sequence Found.
      if(count==0)
      {
        System.out.println("No Common Sequence Found ");    
      }
      System.out.println("\n");
      }    
  
    // close the file
    input.close();
  
  }        
          
}
