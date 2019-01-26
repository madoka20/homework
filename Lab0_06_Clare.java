package madoka_practice;

import java.util.Scanner;

public class Lab0_06_Clare {
	/*
	 * CS240-Lab0-06 Author: Clare 1/24/19 
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("input a few full lines of text: ");
		String list[] = new String[100];//create a list which can hold up to 100 strings
		
		int i = 0;
		while (scan.hasNextLine()) {
			list[i] = scan.nextLine();
			i += 1;
			if (list[i - 1].isEmpty()) {
				break;
			}
		}//get lines from the user until the line is empty
		System.out.println("Number of Line: " + (i - 1));//calculate the number of lines

		System.out.println("Input a character: ");
		String ch = scan.next();
		for (int a = 0; a < i - 1; a++) {
			if (list[a].startsWith(ch)) {
				System.out.println("All lines which start by " + ch + ": " + list[a]);
			}
		}//get a character from user, then print all the lines which start by that character

		System.out.println("Input a word: ");
		String word = scan.next();
		for (int b = 0; b < i - 1; b++) {
			if(list[b].contains(word)) {
				System.out.println("All lines which contain '" + word + "': " + list[b]);
			}
		}//get a word form user, then print all the lines which contain that word
	}
}
/*
input a few full lines of text: 
Projects normally in the course will be paired programming, but you must be able to do these tasks yourself to be successful in the course.
Each solution for the following tasks should be written as a separate Java program. Each indicate the language feature you are to demonstrate. The solution should be tested and the input/output dialog be copied and pasted as a comment at the bottom of each program with comment notation. This is demonstrated below in the example Java code.
You may start with that sample code below to help you learn Java, but be sure to remove all the code that is irrelevant to the solution of each of these tasks. 
Practice good commenting from the beginning!

Number of Line: 4
Input a character: 
P
All lines which start by P: Projects normally in the course will be paired programming, but you must be able to do these tasks yourself to be successful in the course.
All lines which start by P: Practice good commenting from the beginning!
Input a word: 
programming
All lines which contain 'programming': Projects normally in the course will be paired programming, but you must be able to do these tasks yourself to be successful in the course.
*/
