import java.util.Scanner;
import java.util.*;

public class Program2 {
/*
 * CS240-Program2 Author: Clare, Jianxiang, 02/13/19 
 * An interface based on SoundsArray class. User can append clips into array, delete clips from array, insert clips into array or play them.
 * Also, users can choose if reverse or scale the clip when they append or insert the clip.
 */
            
      public static void main (String [] args) {
       
        Scanner keyboard = new Scanner(System.in);
        
        SoundsArray clipsArray = new SoundsArray(100);
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
                    clipsArray.Append(clip);//Append the clip
                    break;
            case 'I':
                   do {
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
                    pos=keyboard.nextInt()-1;//friendly to non-CSPOE users
                   clipsArray.Insert(clip,pos);//Insert the clip
             
                    }while( ! clipsArray.Insert(clip, pos));
                   break;
            case 'D':
                   do {
              System.out.println("Enter the position of the file you want to delete:(Start by 1)");
                    pos=keyboard.nextInt()-1;//friendly to non-CSPOE users
                    clipsArray.Delete(pos);//delete the clip
                    }while(! clipsArray.Delete(pos));
                    break;
            case 'P':
                    clipsArray.Play(0);//play those clips
                    break;
            default:System.out.println("Invalid input. Try again"); //handle bad input
          }
          System.out.print("appropriate prompt");
          command = Character.toUpperCase(keyboard.next().charAt(0));
        }
      }
}
