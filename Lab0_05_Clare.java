package madoka_practice;

import java.util.Scanner;

public class Lab0_05_Clare {
	/*
	 * CS240-Lab0-05 Author: Clare 1/24/19 
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = 0;
		System.out.println("How many numbers do to want? ");//get the number of numbers from user
		n = scan.nextInt();
		System.out.println("Enter " + n + " number(s): ");
		double list[] = new double[n];//create a double list

		for (int i = 0; i < n; i++) {
			double element;
			element = scan.nextDouble();
			list[i] = element;
		}//fill the list
		
		double sum = 0;
		for (int j = 0; j < list.length; j++) {
			sum += list[j];
		}
		double avg = sum / n;
		System.out.println("Sum is " + sum);
		System.out.println("Average is " + avg);//calculate the sum and average

		double max = 0;
		for (int k = 0; k < list.length; k++) {
			if (list[k] > max) {
				max = list[k];
			}
		}
		System.out.println("The largest number is " + max);//find the largest number

		int count = 0;
		for (int l = 0; l < list.length; l++) {
			if (list[l] >= avg) {
				count += 1;
			}
		}//count numbers which is larger than the average
		System.out.println("There is(are) " + count + " number(s) above the average: ");
		for (int m = 0; m < list.length; m++) {
			if (list[m] >= avg) {
				System.out.println(list[m]);
			}
		}//print these numbers

	}

}
/*
How many numbers do to want? 
5
Enter 5 number(s): 
3.1415926
2.18281828
6.66666
9.8765
4.0
Sum is 25.867570880000002
Average is 5.173514176
The largest number is 9.8765
There is(are) 2 number(s) above the average: 
6.66666
9.8765
*/