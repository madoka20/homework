// java prefixEval
//CS240 Program07 Clare(Mingyang), Jianxiang, 3/17/19
//A program to evaluate prefix expression and judge if the expression is valid or too long and too short.
//This is the main program
import java.io.*;
import java.util.*;

public class PrefixEval {

    public static void main (String argv[]) 
    {
           // treat each line as its own scanned object
       Scanner lineInput = new Scanner(System.in);
       while(lineInput.hasNextLine())
       {
          String line = lineInput.nextLine();

             // set up scanning of the line
          Scanner expr = new Scanner(line);
          Prefix p = new Prefix(expr);

             //display results
         try{
              double r = p.result();
              if(p.bo==true){//only print the result when the expression is valid. 
                System.out.println(line + " = " + r);}
       } catch (Exception e){
            System.out.println("bad input");// if the expression contains invalid tokens
           
         }
       
       }
   }
}
/*Sample interaction:
+ 3 4
+ 3 4 = 7.0 
- 9 4
- 9 4 = 5.0 
-596
-596 = -596.0 
- 4 9
- 4 9 = -5.0 
/ * 15 4 + 5 1
/ * 15 4 + 5 1 = 10.0 
- + + 9 8 7 6
- + + 9 8 7 6 = 18.0 
+ * 2 -3 * -4 15
+ * 2 -3 * -4 15 = -66.0 
/ * 309 3 * + 23 9 - 8 3
/ * 309 3 * + 23 9 - 8 3 = 5.79375 
/ 6 - 4 * 2 2
Illegal divide by 0 
+ 4
Not enough numbers or too many operators 
bad input 
+ 1 2 3
Too many numbers or not enough operators or contains invalid opeartor
& 1 2
Too many numbers or not enough operators or contains invalid opeartor
bad input 
+ 3 * 4
Not enough numbers or too many operators 
bad input 
/ 4 - 5 5
Illegal divide by 0 
* 3 oops
bad input 
 * 
 * 
 * 
*/