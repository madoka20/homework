//----------------------------------------------------------------------
// DaysBetween.java          by Dale/Joyce/Weems               Chapter 1
//
// Asks the user to enter two "modern" dates and then reports 
// the number of days between the two dates.
//----------------------------------------------------------------------

package madoka_practice;

import java.util.Scanner;

/*
 * CS240-Lab01-1.1.7 Author: Clare, Jianxiang, 1/30/19 
 * This program converts two dates to lilian number and calculate how many days between these two dates.
 */
public class DaysBetween {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int day, month, year;

		System.out.println("Enter two 'modern' dates: month day year");
		System.out.println("For example, January 21, 1939, would be: 1 21 1939");
		System.out.println();
		System.out.println("Modern dates are not before " + Date.MINYEAR + ".");
		System.out.println();// introduction

		System.out.println("Enter the first date:");
		month = scan.nextInt();
		day = scan.nextInt();
		year = scan.nextInt();
		Date d1 = new Date(month, day, year);// get first date

		System.out.println("Enter the second date:");
		month = scan.nextInt();
		day = scan.nextInt();
		year = scan.nextInt();
		Date d2 = new Date(month, day, year);// get second date

		if ((d1.getYear() <= Date.MINYEAR) || (d2.getYear() <= Date.MINYEAR))
			System.out.println("You entered a 'pre-modern' date.");// check the validity of year
		else {
			System.out.println("The number of days between");
			System.out.print(d1 + " and " + d2 + " is ");
			System.out.println(Math.abs(d1.lilian() - d2.lilian()));// calculate the difference through lilian
		}
	}
}
/*
 * Enter the first date: 2 2 2222 Enter the second date: 2 2 2222 The number of
 * days between 2/2/2222 and 2/2/2222 is 0
 * 
 * Enter the first date: 12 25 2020 Enter the second date: 12 24 2020 The number
 * of days between 12/25/2020 and 12/24/2020 is 1
 * 
 * Enter the first date: 1 9 1919 Enter the second date: 1 16 1919 The number of
 * days between 1/9/1919 and 1/16/1919 is 7
 * 
 * Enter the first date: 7 25 1584 Enter the second date: 7 25 1585 The number
 * of days between 7/25/1584 and 7/25/1585 is 365
 * 
 * Enter the first date: 2 27 2020 Enter the second date: 2 27 2021 The number
 * of days between 2/27/2020 and 2/27/2021 is 366
 */
