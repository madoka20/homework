package madoka_practice;

import java.util.Scanner;

public class Lab0_02_Clare {
	/*
	 * CS240-Lab0-02 Author: Clare 1/21/19 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input three numbers:");
		double n1, n2, n3;
		Scanner keyboard = new Scanner(System.in);
		n1 = keyboard.nextDouble();
		n2 = keyboard.nextDouble();
		n3 = keyboard.nextDouble();//get three numbers from the user
		System.out.print("The sum of those two numbers is: ");
		System.out.println(n1 + n2 + n3);//calculate the sum
		System.out.print("The average of those three number is: ");
		System.out.println((n1 + n2 + n3) / 3);//calculate the average

	}
}
/*
 * Input three numbers: 142857 285714 571428 The sum of those two numbers is:
 * 999999.0 The average of those three number is: 333333.0
 */