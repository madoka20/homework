//----------------------------------------------------------------------
// PostFixEvaluator.java       by Dale/Joyce/Weems             Chapter 2
//
// Provides a postfix expression evaluation.
//----------------------------------------------------------------------

//package ch02.postfix;

/* CS240 Program05 Clare(Mingyang), Jianxiang, 2/28/2019
 * PostFixEvaluator class
 * binary operator "^"(power) and "%"(module) added
 * unary operator "~"(negate) and "$"(square) added
 */
import ch02.stacks.*;
import java.util.Scanner;

public class PostFixEvaluator
{
  public static int evaluate(String expression)
  {
    Scanner tokenizer = new Scanner(expression);
    StackInterface<Integer> stack = new ArrayBoundedStack<Integer>(50);  

    int value;
    String operator;
    int operand1, operand2,operand3;//op1 and op2 is used for binary operator, op3 is used for unary operator
    int result = 0;

    while (tokenizer.hasNext())
    {
      if (tokenizer.hasNextInt())
      {
        // Process operand.
        value = tokenizer.nextInt();
        if (stack.isFull())
          throw new PostFixException("Too many operands-stack overflow");
        stack.push(value);
      }
      else
      {
        // Process operator.
        operator = tokenizer.next();
        
        // Check for illegal symbol
        if (!(operator.equals("/") || operator.equals("*") ||
              operator.equals("+") || operator.equals("-")||operator.equals("%")||operator.equals("$")||operator.equals("~")||operator.equals("^"))){
          throw new PostFixException("Illegal symbol: " + operator);}
        
        //check for binary operators
        if(operator.equals("/") || operator.equals("*") ||
           operator.equals("+") || operator.equals("-")||operator.equals("%")||operator.equals("^")){
        // Obtain second operand from stack.
        if (stack.isEmpty())
          throw new PostFixException("Not enough operands-stack underflow");
        operand2 = stack.top();
        stack.pop();

        // Obtain first operand from stack.
        if (stack.isEmpty())
          throw new PostFixException("Not enough operands-stack underflow");
        operand1 = stack.top();
        stack.pop();

        // Perform operation.
        if (operator.equals("/")){
          if(operand2==0){
          System.out.println("Illegal divide by 0");//if op2 is zero, throw exception
        }
          if(operand2!=0){
            result = operand1 / operand2;}}
        else if(operator.equals("*")){//multipy
          result = operand1 * operand2;}
        else if(operator.equals("+")){//plus
          result = operand1 + operand2;}
        else if(operator.equals("-")){//minus
          result = operand1 - operand2;}
        else if(operator.equals("%")){//module
          result = operand1 % operand2;}
        else if(operator.equals("^")){//power
          result = operand1;
          for(int i=1;i<operand2;i++){
            result*=operand1;
          }//loop for calculate power
        }

        }
        //check for unary operators
        if(operator.equals("$") || operator.equals("~") ){
          //obtain the operand from stack
         if (stack.isEmpty())
          throw new PostFixException("Not enough operands-stack underflow");
        operand3 = stack.top();
        stack.pop();
        if(operator.equals("$")){//square
        result=operand3*operand3;
        }
        if(operator.equals("~")){//negate
        result=operand3*-1;
        }
       
        }
         stack.push(result);
        
        // Push result of operation onto stack.
        
      }
    }

    // Obtain final result from stack. 
    if (stack.isEmpty())
      throw new PostFixException("Not enough operands-stack underflow");
    result = stack.top();
    stack.pop();

    // Stack should now be empty.
    if (!stack.isEmpty())
      throw new PostFixException("Too many operands-operands left over");

    // Return the final.
    return result;
  }
}