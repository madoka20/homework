import java.util.Scanner;
/*
 * CS240-Program1 Author: Clare, Jianxiang, 02/09/19 
 * input an array of sound clips and randomly play these clips within a period of time, and then play them in order once.
 */
public class Program1 {
 public static void main(String[] args) {
  int n;// number of clips
  Sound[] sounds = null; //create an array of sound clips 

  Scanner keyboard = new Scanner(System.in);
  System.out.println("Enter number of sound files: ");

  n = keyboard.nextInt();//get number of clips from user
  if(n>=5){//handle bad input
  
  sounds = new Sound[n];//update the length of array

  for (int i = 0; i < n; i++) {
   String fileName = FileChooser.pickAFile();
   sounds[i] = new Sound(fileName);
  }//pick n files from the user and store them into the sound array
  System.out.println("Enter the total time (sec): ");
  int time;
  time = keyboard.nextInt() * 1000;//get the time from the user and convert it to ms
  int time1 = time;//copy the time into time1 for the second play
  while (time > 0) {//when time is not below zero
   int rand = (int) (Math.random() * n);//randomly pick a number which between 0 and n-1
   System.out.println("The time remaining is " + time + " ms");//print out the remaining time
   System.out.println("The file name is: " + sounds[rand].getFileName());//print out the file name
   System.out.println("The length of clip is " + sounds[rand].getLength() / 22.05 + " ms");//print out the length of the clip
   sounds[rand].blockingPlay();//play the clip
   time -= (sounds[rand].getLength() / 22.05);//subtract the time of clip from the total
   try {
    Thread.sleep(250); // Wait a half sec
   } catch (Exception e) {
    System.err.println("Exception: " + e.getMessage());
    System.err.println("Stack Trace is:");
    e.printStackTrace();
   }
  }

  try {
   Thread.sleep(3000); // Wait three sec, to distinguish the first and second mashup
  } catch (Exception e) {
   System.err.println("Exception: " + e.getMessage());
   System.err.println("Stack Trace is:");
   e.printStackTrace();
  }

  for (int j = 0; j < n; j++) {

   sounds[j].blockingPlay();
   time1 -= sounds[j].getLength() / 22.05;
   if (time1 <= 0) {
    break;
   }
  }//play the clips from the sound array in order, after play once or the time is exhausted, stop
  }else{System.out.println("You need at least 5 cilps!");
  }
 }
}
/*
Enter number of sound files:  
6
Couldn't save media path to a file 
Enter the total time (sec):  
6
The time remaining is 6000 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\mark.wav 
The length of clip is 1625.3968253968253 ms 
The time remaining is 4374 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\my.wav 
The length of clip is 602.1768707482993 ms 
The time remaining is 3771 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\my.wav 
The length of clip is 602.1768707482993 ms 
The time remaining is 3168 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\mark.wav 
The length of clip is 1625.3968253968253 ms 
The time remaining is 1542 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\and.wav 
The length of clip is 520.0907029478458 ms 
The time remaining is 1021 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\my.wav 
The length of clip is 602.1768707482993 ms 
The time remaining is 418 ms 
The file name is: X:\Academic\Rhodes\drjava\mediasources\mark.wav 
The length of clip is 1625.3968253968253 ms 
*/
