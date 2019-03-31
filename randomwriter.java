import java.io.*;
   import java.util.*;
public class randomwriter
  //CS240 - Program 08 by Clare(Mingyang),Jianxiang. Last modified: 3/29/19
  //a Linked-list made random writer to write a random essay based on a given text. 
  //The basic idea is to store the unique words into an arraylist and then store all of the follow words into its corresponding linkedlist.
  //Then randomly pick word from a random list, then randomly pick a word from the list of that word, repeatly do this until N words.
   {
   public static void main(String[] args) throws IOException 
   { 
 //Get file name arguments from command line or interactively as entered by user
   String sourceFileName = "C:\\Users\\Administrator\\Desktop\\randomwriter\\constitution.txt";//source file
   String resultFileName  = "C:\\Users\\Administrator\\Desktop\\randomwriter\\result.txt";//result file
   System.out.println("Enter the words you want to generate: "); 
   Scanner s1=new Scanner(System.in);
   
   int N = s1.nextInt();//get the number of output words
  
   long startTime; //for emperical time measurement
   long stopTime;  //elapsed time is difference in millisec
 
   ArrayList <String> unique = new ArrayList<String>();//the arraylist of unique words
   ArrayList <LinkedList<String>> follows = new ArrayList <LinkedList<String>>();//the arraylist of linkedlist of following words
   
   startTime = System.currentTimeMillis();//start time measuring of input 
   
   Scanner dataFile = new Scanner(new FileReader(sourceFileName));//scan the file 
   String current = dataFile.next(); //set current to the first word of the text
      
   //step1:create a unique words arraylist and then create a corresponding arraylist of linkedlists
   while(dataFile.hasNext()){
     if(!unique.contains(current)){
       unique.add(current);}
       current=dataFile.next();
       }//create unique arraylists. The idea is if the arraylist already contain that word, ignore that.
   for(int i=0;i<unique.size();i++){
       follows.add(i,new LinkedList<String>());
   }//add the same number of linkedlist into follows
     System.out.println("Number of unique words: "+unique.size());//count unique words
     System.out.println("Number of unique Linkedlists: "+follows.size());//count linkedlists (these two must the same number)
   
   
   PrintWriter outFile     = new PrintWriter(new FileWriter(resultFileName));//writer
      
   //step2:store all the following words into corresponding linkedlist in "follows"
   String next;//the follow word
   LinkedList l;//the corresponding linkedlist of that word (current1)
     Scanner dataFile1 = new Scanner(new FileReader(sourceFileName));//scan the file again
    String current1 = dataFile1.next(); //get the first word again
   while(dataFile1.hasNext()){
     next=dataFile1.next();
    l=(LinkedList) follows.get(unique.indexOf(current1));
    l.add(next);
    current1=next; 
   }//the idea is, store the following words one by one into their corresponding linkedlist.

   stopTime = System.currentTimeMillis();
   System.out.println("Elapsed input time = "+(stopTime-startTime)+" msecs.");//time measuring for input ended
   
   //step3:randomly pick a word and then start from this word to randomly generate a essay of N words.
   startTime = stopTime;//reset time for output measuring
   outFile.println("\n------------random essay----------------");
   outFile.flush();
   
   String word="";//the randomly picked word
   LinkedList ll;//the linkedlist that the word in
   Random r=new Random();
   int rn=r.nextInt(unique.size());//random number between 0 and size of unique words
   ll = (LinkedList)(follows.get(rn));//get the randomly linkedlist
 
   while(N>0){
 
    int nrn=r.nextInt(ll.size());//get another random number for pick the word
    word=(String)ll.get(nrn);//pick the word
    try{
      ll=(LinkedList)follows.get(unique.indexOf(word));}
    catch(Exception e){}//change the linkedlist to the corresponding linkedlist of that word 
    //when reach the last word (which may doesn't have following word, the linkedlist is empty), just ignore that by catch the OutOfBoundException(-1)
   outFile.print(word+" ");//print the word
   N--;
   }//do N times
   
   outFile.flush();
   outFile.close();
   stopTime = System.currentTimeMillis();//stop measuring time for output
   System.out.println("Elapsed output time = "+(stopTime-startTime)+" msecs.");//print the time
   
 }
}


