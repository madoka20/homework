package madoka_practice;

import java.util.Scanner;

public class Lab0_03_Clare {
	/*
	 * CS240-Lab0-03 Author: Clare 1/22/19 
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int times;
		System.out.println("How many numbers do to want?");
		times = keyboard.nextInt();//get the number of numbers from user
		double total = 0;
		System.out.println("Input " + times + " number(s):");
		for (int i = 0; i < times; i++) {
			double num;
			num = keyboard.nextDouble();//get numbers from the user through the loop
			total += num;//each number will accumulate to total
			System.out.println("The sum of these numbers is " + total);
		}
		double avg = total / times;//calculate the average
		System.out.println("The average of these numbers is " + avg);
	}
}
/*
How many numbers do to want?
6
Input 6 number(s):
111111
The sum of these numbers is 111111.0
222222
The sum of these numbers is 333333.0
333333
The sum of these numbers is 666666.0
444444
The sum of these numbers is 1111110.0
555555
The sum of these numbers is 1666665.0
666666
The sum of these numbers is 2333331.0
The average of these numbers is 388888.5

*/