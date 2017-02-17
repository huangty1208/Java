
/*
  File: CreditCard.java

  Description: This program will will test whether a given 15 or 16-digit credit card number is valid or not.

  Student Name: TienYu Huang

  Student UT EID: th23897

  Course Name: CS 312

  Unique Number: 90125

  Date Created: 07/17/14

  Date Last Modified: 07/17/14

*/

// import scanner class
import java.util.Scanner;

public class CreditCard
{
  public static void main(String[] args) 
  {
  Scanner input = new Scanner(System.in);
     
  System.out.print("Enter 15 or 16-digit credit card number: ");
  
  // read the credit card number in as a long   
  long num = input.nextLong();
  
  // check if it is a 15 or 16-digit number
  String numS = ""+num;
  
  //write an error message and exit the program using a return statement.
  if(numS.length()!= 15 && numS.length()!= 16) 
  {
  System.out.println("\n"+"Not a 15 or 16-digit number");
  return;
  }
  
  // perform the Luhn's test and get the result back
  // If the credit card number is not valid then you will print a statement to that effect.
  if(!is_valid(num))
  System.out.println("\n"+"Invalid credit card number");
  
  //If the credit card number is valid then you will print the type of credit card (American Express, MasterCard, Visa, etc.) and that it is valid.
  else
  System.out.println("\n"+"Valid "+cc_type(num)+"credit card number");
 
 
  }
  
  // This method checks if a credit card number is valid by running Luhn's Test
   public static boolean is_valid (long cc_num) {
   
   int sumOdd = 0 ;
   long oddNum = cc_num/10;
   
   // get all the odd digits and multiply by 2  
   while(oddNum >0)
   {
   int odd = (int)((oddNum)%10) ;
   odd = odd * 2 ;
   // Sum the digits of each product.
   if (odd >=10)
   {
   odd=odd/10+odd%10 ;
   }    
   
   // sum the single digit products of the odd digits.
   sumOdd += odd ;
   oddNum=oddNum/100 ;       
   }    
   
   int sumEven = 0 ;
   long evenNum = cc_num;
   
   // Now add all the even digits
   while(evenNum > 0)
   {
   int even = (int)(evenNum % 10) ;

   sumEven += even ;
   evenNum=evenNum/100 ;       
   }       
   
   // If the final sum is divisible by 10 then the credit card is valid, otherwise it is invalid.
   return ((sumOdd+sumEven)%10==0);  
   
   }

 
   // This method returns the type of credit card
   public static String cc_type (long cc_num) { 
   
   // get the first few digits of a credit card and save it as Strings  
   String cc = ""+cc_num;
   String ccL1 = cc.substring(0,1);
   String ccL2 = cc.substring(0,2);
   String ccL3 = cc.substring(0,3);
   String ccL4 = cc.substring(0,4);
   
   // identifyingthe following cards that start with the given digits
   if(ccL1.equals("4"))
   return "Visa "  ;  
   
   else if(ccL2.equals("50") || ccL2.equals("51") || ccL2.equals("52") || ccL2.equals("53") || ccL2.equals("54") || ccL2.equals("55"))
   return "MasterCard ";  
   
   else if (ccL2.equals("34") || ccL2.equals("37"))
   return "American Express ";
   
   else if(ccL2.equals("65") || ccL3.equals("644")||ccL4.equals("6011"))
   return "Discover ";
   
   else
   return "";
   
   }
  
}
