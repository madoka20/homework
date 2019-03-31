import java.io.*;
import java.util.*;
//CS240 Program07 Clare(Mingyang), Jianxiang, 3/17/19
//A program to evaluate prefix expression and judge if the expression is valid or too long and too short.
//This is the prefix class and result function
public class Prefix {
    private Scanner line;
   public boolean bo=true;//judge if the expression is valid
        int opCount=0;//count processed operators
        int numCount=0;//count processed numbers
    public Prefix( Scanner s){
      line=s;
    }

    public double result () {

        String token = "";

        if(line.hasNext()){
          token = line.next();
          
          //if the token is valid operator, count operators.
          if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
          opCount++;
          }
          else{numCount++;}//else the token is number, and count numbers
       
          if((numCount==opCount+1)&&line.hasNext()){System.out.println("Too many numbers or not enough operators or contains invalid opeartor");bo=false;}
          //since every expression has n numbers and n-1 operators, if the expression still has unprocessed token, the expreesion is to long and invalid
        
        }//get the next token
        
        else {System.out.println("Not enough numbers or too many operators");bo=false;}//if don't have next token, the expression in too short and invalid
       
        
        
      
      
        if(token.equals("+")){
            double a = result();
            double b = result();
          
           return a+b;
            
        } else if(token.equals("-")){
            double c = result();
            double d = result();
        
            return c-d;
        } else if(token.equals("*")){
            double e = result();
            double f = result();
        
            return e*f;
        } else if(token.equals("/")){
            double g = result();
            double h = result();
             
            if(h==0){
            System.out.println("Illegal divide by 0");bo=false;
            }//if divide by 0 then expression will be invalid
            return g/h;
        }   
       
        
        
        else{
          double r;
          r= Double.parseDouble(token);
        return r;//if the tokens are number, parse it to double for next calculation.
        }
    }
}
       
        
         
      

