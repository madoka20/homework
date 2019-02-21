//package ch02.apps;
/*
 * CS240-Program4 Author: Clare, Jianxiang, 02/14/19 
 * Checks for balanced grouping symbols of each line of a file. Special symbol types are (),[],{},<>,/\.
 * When the line of symbol group is not balanced, tell the user which symbol cause the line unbalanced and the position of that symbol.
 */
import java.util.*;
import java.io.*;

//import ch02.balanced.*;

public class BalancedCLI
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

  // Instantiate new Balanced class with grouping symbols.
    Balanced bal = new Balanced("([{</", ")]}>\\");//<> and /\ added
    
    int result; // 0 = balanced, 1 = unbalanced, 2 = premature end
    String expression=null;
   Scanner kbd = new Scanner(System.in);
   System.out.println("Enter filename: ");
   BufferedReader dataFile = null; 
   String dataFileName = kbd.nextLine(); //get file name from user
   ArrayList<String> arr=new ArrayList<>();//create an arraylist to store lines
try{
      dataFile = new BufferedReader(new FileReader(dataFileName));//read the file into bufferedreader
      while((expression=dataFile.readLine())!=null)
      {
     arr.add(expression);//add each line of the file into array until end of the file
      }
      dataFile.close();
 } catch (Exception e) {
   e.printStackTrace(); 
 }  


  final String STOP = "X"; // X indicates end of file
    for(String temp:arr){

      //iterate through the arraylist
      System.out.print("Expression (" + STOP + " to stop): ");
     
      if (!STOP.equals(temp))
      {      
         // Obtain and output result of balanced testing.
         result = bal.test(temp);
         if (result == 1)
           System.out.println(temp+" is Unbalanced \n "+"Unbalanced symbol\""+bal.currChar+"\"found at location "+bal.currCharIndex);
         //tell the user the position of the symbol that cause unbalancing and what symbol it is
         else
         if (result == 2)
           System.out.println(temp+" is Premature end of expression \n");
         else
           System.out.println(temp+ "is Balanced \n");
      }
 
    }
  }
}
/*Sample Interaction
 Enter filename:  
test.txt
Expression (X to stop): (xx(xx())xx))[] is Unbalanced 
 Unbalanced symbol")"found at location 13 
Expression (X to stop): ((((()))) is Premature end of expression 
 
Expression (X to stop): </123/\\>>{{{)}}} is Unbalanced 
 Unbalanced symbol">"found at location 10 
Expression (X to stop): <({}[}]>) is Unbalanced 
 Unbalanced symbol"}"found at location 6 
Expression (X to stop): ()[]{}<>(){}[]/\is Balanced 
 
Expression (X to stop): (<>)[[[//abc\\]]]{{{{<<p>>}}}}is Balanced 
 
Expression (X to stop): <({[[{()}[{(  )}]]]}())>is Balanced 
 
Expression (X to stop): (xx(xx<>xx)[] is Premature end of expression 
 
Expression (X to stop): ()<>[]{(/\)[}]{} is Unbalanced 
 Unbalanced symbol"}"found at location 13 
Expression (X to stop): (())[[[]]]<<>>{{{{}}}}/\) is Unbalanced 
 Unbalanced symbol")"found at location 25 
Expression (X to stop): <({[[{()}{()}]]]}())> is Unbalanced 
 Unbalanced symbol"]"found at location 16 
Expression (X to stop): xxxxxxxxxx/x is Premature end of expression 
 
Expression (X to stop): (\/) is Unbalanced 
 Unbalanced symbol"\"found at location 2 
Expression (X to stop): x x x x x is Balanced 
 
Expression (X to stop): > 
 */