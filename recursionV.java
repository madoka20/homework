/******************************************
 * recursionV.java -- a template for recursion exploration
 *
 * L.Rhodes 3/3/10
 * LKR modified 3/13/12 for use with Scanner class
 *
 *******************************************/
//CS240 Program06 Clare(Mingyang), Jianxiang, 3/4/19
//a recursive function to reverse an integer and print it.(Ex. input 2019, output 9102)
import java.util.Scanner;
class recursionV
{
   public static void main(String args[])
   {
      Scanner kb = new Scanner(System.in);
      int n = 0;  // input limit
      String line = "";
      System.out.print("Enter n: ");
      while(!kb.hasNextInt()){
          System.out.print("Enter an integer: ");
          line = kb.next();
      }
      n = kb.nextInt();
      System.out.print("The reversion of "+n+" is: ");
      recursiveV(n);
      System.out.println();

  
   }


   static void recursiveV(int n)
   {
      

      //base case
      if (n <= 9) {
          System.out.print(n+" ");
          return;
    }
      //recursive case
      int a=0;
      a=n%10;//get the last digit
      System.out.print(a);//print the last digit 
      recursiveV(n/10);//divide by 10 each time until n<=9
      return;
   }
   
}
/*Sample interaction

Enter n: 0001234567
The reversion of 1234567 is: 7654321  

Enter n: 10000
The reversion of 10000 is: 00001  

Enter n: 342019
The reversion of 342019 is: 910243  
 
 */