/******************************************
 * recursionI.java -- a template for recursion exploration
 *
 * L.Rhodes 3/3/10
 * LKR 3/13/12 altered to use Scanner class
 *
 *******************************************/
//CS240 Program06 Clare(Mingyang), Jianxiang, 3/4/19
//a recursive function to compute the floor of the log-base 2 of n. Ex. Floor(log 2 18)=4, Floor(log 2 1023)=9

import java.util.Scanner;
class recursionI
{
   public static void main(String args[])
   {
      Scanner kb = new Scanner(System.in);
      int n = 0;  // input limit
      String line = "";
      System.out.print("Enter n: ");
      while(!kb.hasNextInt()){
         line = kb.next();
         System.out.println("Please enter an integer: ");
      }
      n = kb.nextInt();

      System.out.println("Floor of the log-base 2 of n: "
          + recursiveI(n));

   }

  
   static int recursiveI(int n)
   {
    
     int a=0;
       //base case
       if( n < 2) return 0;
        //recursive case
       a+=1;
       return recursiveI(n/2)+a;//divide by 2 each time until n<2
   }

}
/*Sample interaction
 
Enter n: 1048575
Floor of the log-base 2 of n: 19 

Enter n: 1048576
Floor of the log-base 2 of n: 20 

Enter n: 2000000000
Floor of the log-base 2 of n: 30 

 
 */