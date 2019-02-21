/*
 * CS240-Program2 Author: Clare, Jianxiang, 02/13/19 
 * The SoundsArray class. It contains sounds array constructor and several methods which are append, insert, delete and play.
 * These methods are used to modify the sounds array.
 */
      
public class SoundsArray {
   private Sound [] clips;  // the array of clips
   private int DEFAULT_MAX_SIZE = 100;
   private int n=0;   // number of active clips
   
   
   public SoundsArray(){
     clips=new Sound[DEFAULT_MAX_SIZE];
     }//default constructor
  
   

   public SoundsArray(int size){
   clips=new Sound[size];
   }//constructor with size assigned

 
    public void Append(Sound clip){
      
      clips[n]=clip;
      n++;
    }//Add 1 clip at the end of clips
      
    public boolean Delete(int p){
        if(p<0 || p>n){ 
          System.out.println("The position is invalid");
          return false;
        }//handle bad input and try again
       
        for(int i=p;i<n;i++){
          clips[i]=clips[i+1];
        }//delete a clip, then move clips which are right of the deleted position to the left for 1 position.
      n--;
      return true;
    }
      
    public boolean Insert (Sound clip, int p){
      if(p<0 || p>n){ 
          System.out.println("The position is invalid");
        return false;
      }//handle bad input and try again
      for(int i=n-1;i>=p;i--){
        clips[i+1]=clips[i];
      }//move clips which are right of the insert position to the right for 1 position
      clips[p]=clip;//then fill the blank with the file 
      n++;
      return true;
    }

    public void Play(int delayBtw){
        try {
   Thread.sleep(delayBtw); 
  } catch (Exception e) {
   System.err.println("Exception: " + e.getMessage());
   System.err.println("Stack Trace is:");
   e.printStackTrace();
  }
      for (int i=0;i<n;i++){
        clips[i].blockingPlay();
      }
   
       //play the clips in the array with a delay of delayBtw msec
    }
} 
 
