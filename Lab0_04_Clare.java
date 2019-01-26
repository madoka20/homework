package madoka_practice;

import java.util.Scanner;

public class Lab0_04_Clare {
	/*
	 * CS240-Lab0-04 Author: Clare 1/23/19  Revised:1/25/19
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int count=0;
		System.out.println("Enter a line of words then use # to flag the end");//I tried ^D or ^Z, but they didn't work.
		String maxword="";//define a empty variable to save the current longest word 
		while(!keyboard.hasNext("#")) {//The symbol # can terminate this loop
			String word=keyboard.next();//get words from user
			if (word.length()>maxword.length()){
				maxword=word;//find the longest word
			}
		count+=1;
		}
		System.out.println("The longest word has "+ maxword.length() +" characters");
		System.out.println("The longest word is "+maxword);
		System.out.println("Total: "+count+" words");

	}
}
/*
Enter a line of words then use # to flag the end
There are 6 preliminary Java tasks outlined here. Upload the 6 solution java files that have your sample runs added as a final comment block.  Do not change the file names! #
The longest word has 11 characters
The longest word is preliminary
Total: 31 words
*/