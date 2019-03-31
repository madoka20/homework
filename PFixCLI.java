//----------------------------------------------------------------------
// PFixCLI.java           by Dale/Joyce/Weems                  Chapter 2
//
// Evaluates postfix expressions entered by the user.
// Uses a command line interface.
//----------------------------------------------------------------------
//package ch02.apps;

/* CS240 Program05 Clare(Mingyang), Jianxiang, 2/28/2019
 * evaluate a postfix expression which is entered by user and return the result. 
 * If the operator or operands are to much or to less, throw exception and continue
 * If divide by 0, throw exception and continue
 */
import java.util.Scanner;
import ch02.postfix.*;

public class PFixCLI 
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    String expression = null;    // expression to be evaluated
    final String STOP = "X";     // indicates end of input
    int result;                  // result of evaluation

    while (!STOP.equals(expression))
    {
      // Get next expression to be processed.
      System.out.print("\nPostfix Expression (" + STOP + " to stop): ");
      expression = scan.nextLine();
      
      if (!STOP.equals(expression))
      {      
         // Obtain and output result of expression evaluation.
         try
         {
           result = PostFixEvaluator.evaluate(expression);
           
   
           // Output result.
           System.out.println("Result = " + result);
         }
        
         catch (PostFixException error)
         {        
           // Output error message.
           System.out.println("Error in expression - " + error.getMessage());
         }
      }
    }
  }
}
/*Sample interactions
Postfix Expression (X to stop): 1
Result = 1 

Postfix Expression (X to stop): 999
Result = 999 

Postfix Expression (X to stop): 1 99 +
Result = 100 

Postfix Expression (X to stop): 2 3 4 + * 5 -
Result = 9 

Postfix Expression (X to stop): 5 7 + 6 2 - *
Result = 48 

Postfix Expression (X to stop): 12 3 / 5 /
Result = 0 

Postfix Expression (X to stop): 1 2 3 +
Error in expression - Too many operands-operands left over 

Postfix Expression (X to stop): 1 2 3 + + +
Error in expression - Not enough operands-stack underflow 

Postfix Expression (X to stop): 5 3 2 1 + - /
Illegal divide by 0 
Result = 0 

Postfix Expression (X to stop): 4 $ 3 $ +
Result = 25 

Postfix Expression (X to stop): 4 9 - ~ 7 *
Result = 35 

Postfix Expression (X to stop): 2 6 ^
Result = 64 

Postfix Expression (X to stop): 1 2 3 4 5 6 7 8 9 ^ + + - - * * + ~ $
Result = 1610618065 

Postfix Expression (X to stop): 62 11 43 + 45 7 % * - 
Result = -100 

Postfix Expression (X to stop): 2 4 10 * 5 8 * - /
Illegal divide by 0 
Result = 0 

Postfix Expression (X to stop): 2019 2 28 + - 
Result = 1989 

Postfix Expression (X to stop): 1 2 + 3 4 * + 5  - 6 * 7 % 8 * $ 9 + ~ 10 * $ 
Result = 106708900 

Postfix Expression (X to stop): 1 3 7 9 11 13 37 * * * * * +
Result = 1000000 

Postfix Expression (X to stop): 7 7 7 7 7 7 7 ^ - * + * - 
Result = 40353222 

 */