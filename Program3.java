import java.util.Scanner;
import java.util.*;

public class Program3 {
/*
 * CS240-Program3 Author: Clare, Jianxiang, 02/25/19 
 * The main program of LLSoundList.
 */
            
      public static void main (String [] args) {
       
        Scanner keyboard = new Scanner(System.in);
        
       LLSoundList llsl=new LLSoundList();//create a new sound linkedlist
       Sound clip = null;  
        int pos = 0;        //position
        
        System.out.print("appropriate prompt");       
        char command = Character.toUpperCase(keyboard.next().charAt(0));
        
        while (command != 'Q'){//Q for quit
          switch (command){
            case 'A': 
                   String f1 = FileChooser.pickAFile();
                   clip = new Sound(f1);//choose a file from user
                     System.out.println("Reverse?Y/N");
                   String r1;
                   r1=keyboard.next();
                   if(r1=="Y"){
                     clip=clip.reverse();//ask user if reverse
                   }
                   
                   System.out.println("Enter the scale: ");
                     double s1;
                   s1=keyboard.nextDouble();
                   clip.scale(s1);//ask user how much scale
                    llsl.append(clip);//Append the clip
                    break;
            case 'I':
             
             String f2 = FileChooser.pickAFile();
                   clip = new Sound(f2);//choose a file from user
                     System.out.println("Reverse?Y/N");
                   String r2;
                   r2=keyboard.next();
                   if(r2=="Y"){
                     clip=clip.reverse();//ask user if reverse
                   }
                   
                   System.out.println("Enter the scale: ");
                     double s2;
                   s2=keyboard.nextDouble();
                   clip.scale(s2);//ask user how much scale
                   
                    System.out.println("Enter the position you want to insert the file in: (Start by 1)");
                    pos=keyboard.nextInt()-1;
                    while(pos<0||pos>llsl.nSounds){
                      System.out.print("Invalid input. Position should between 1 and "+(llsl.nSounds+1)+" (Inclusive)");
                      pos=keyboard.nextInt()-1;
                    }//if the position is larger than nSound or less than 0,let user enter again with hint.
                    //friendly to non-CSPOE users
                    
                   llsl.insert(clip,pos);//Insert the clip
            
                    
                   break;
            case 'D':
                   
              System.out.println("Enter the position of the file you want to delete:(Start by 1)");
                    pos=keyboard.nextInt()-1;//friendly to non-CSPOE users
                    while(pos<0||pos>=llsl.nSounds){
                       System.out.print("Invalid input. Position should between 1 and "+(llsl.nSounds)+" (Inclusive)");
                      pos=keyboard.nextInt()-1;
                    }//if the position is larger than nSound or less than 0,let user enter again with hint.
                    llsl.delete(pos);//delete the clip
                   
                    break;
            case 'P':
                    llsl.play(2,4);//play clips between a and b
                    break;
            default:System.out.println("Invalid input. Try again"); //handle bad input
          }
          System.out.print("appropriate prompt");
          command = Character.toUpperCase(keyboard.next().charAt(0));
        }
      }
}
/* Sample interactions
appropriate prompta
Reverse?Y/N 
y
Enter the scale:  
2
appropriate prompta
Reverse?Y/N 
n
Enter the scale:  
1
appropriate prompti
Reverse?Y/N 
n
Enter the scale:  
1.4
Enter the position you want to insert the file in: (Start by 1) 
2
appropriate prompti
Reverse?Y/N 
n
Enter the scale:  
1
Enter the position you want to insert the file in: (Start by 1) 
3
appropriate promptp
appropriate promptd
Enter the position of the file you want to delete:(Start by 1) 
7
Invalid input. Position should between 1 and 4 (Inclusive)5
Invalid input. Position should between 1 and 4 (Inclusive)4
appropriate promptp
appropriate promptq

*/