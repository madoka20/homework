//CS240 Program06 Clare(Mingyang), Jianxiang, 3/4/19
//The addition of recursionI
//a recursive function to compute the floor of the log-base b of n.(user should enter the value of b)
//Ex. Floor(log 10 1024)=3, Floor(log 7 343)=3
import java.util.Scanner;
class recursionII
{
   public static void main(String args[])
   {
      Scanner kb = new Scanner(System.in);
      int n = 0;  // input limit
      int b=0; 
      String line = "";
      System.out.print("Enter n: ");
      while(!kb.hasNextInt()){
         line = kb.next();
         System.out.println("Please enter an integer: ");
      }
      n = kb.nextInt();
     
      System.out.println("Please enter the base: ");
      
      b=kb.nextInt();
      System.out.println("Floor of the log-base "+b+ " of n:"+ recursiveII(n,b));

   }

 
   static int recursiveII(int n,int b)
   {
     
     int a=0;
       //base case
       if( n < b) return 0;
      //recursive case
       a+=1;
       return recursiveII(n/b,b)+a;//divide b each time until n<b
   }

}
/*Sample interaction

Enter n: 1024
Please enter the base:  
2
Floor of the log-base 2 of n:10 

Enter n: 33333
Please enter the base:  
7
Floor of the log-base 7 of n:5 

Enter n: 20190304
Please enter the base:  
9
Floor of the log-base 9 of n:7 

Enter n: 342
Please enter the base:  
7
Floor of the log-base 7 of n:2 

Enter n: 343
Please enter the base:  
7
Floor of the log-base 7 of n:3 

 */