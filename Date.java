//----------------------------------------------------------------------
// Date.java              by Dale/Joyce/Weems                  Chapter 1
//
// Defines date objects having year, month, and day attributes.
//----------------------------------------------------------------------

package madoka_practice;

import java.util.Scanner;

/*
 * CS240-Lab01-1.1.8 Author: Clare, Jianxiang, 1/31/19 
 * This program contains a date class, which include constructor, observers, 
 * and a function to convert date to lilian number.
 * The compareTo function is used to calculate the difference between two dates. 
 * If the first date is earlier than the second date, then return a negative number. 
 * If the first date is after the second date, then return a positive number.
 * If these two date is the same day, then return zero.
 */
public class Date {
	protected int year, month, day;
	public static final int MINYEAR = 1583;

	// Constructor
	public Date(int newMonth, int newDay, int newYear) {
		month = newMonth;
		day = newDay;
		year = newYear;
	}

	// Observers
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int lilian() {
		// Returns the Lilian Day Number of this date.
		// Precondition: This Date is a valid date after 10/14/1582.
		//
		// Computes the number of days between 1/1/0 and this date as if no calendar
		// reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1.

		final int subDays = 578100; // number of calculated days from 1/1/0 to 10/14/1582

		int numDays = 0;

		// Add days in years.
		numDays = year * 365;

		// Add days in the months.
		if (month <= 2)
			numDays = numDays + (month - 1) * 31;
		else
			numDays = numDays + ((month - 1) * 31) - ((4 * (month - 1) + 27) / 10);

		// Add days in the days.
		numDays = numDays + day;

		// Take care of leap years.
		numDays = numDays + (year / 4) - (year / 100) + (year / 400);

		// Handle special case of leap year but not yet leap day.
		if (month < 3) {
			if ((year % 4) == 0)
				numDays = numDays - 1;
			if ((year % 100) == 0)
				numDays = numDays + 1;
			if ((year % 400) == 0)
				numDays = numDays - 1;
		}

		// Subtract extra days up to 10/14/1582.
		numDays = numDays - subDays;
		return numDays;
	}

	@Override
	public String toString()
	// Returns this date as a String.
	{
		return (month + "/" + day + "/" + year);
	}

	public int compareTo(Date date) {
		return this.lilian() - date.lilian();
	}// To calculate the difference between two dates.

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int day, month, year;
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

		Date d3 = new Date(1, 31, 2019);
		Date d4 = new Date(5, 18, 2021);// These are for testing

		System.out.println("The result from comparing " + d1 + " to " + d2 + " is " + d1.compareTo(d2));
		System.out.println("The result from comparing " + d4 + " to " + d3 + " is " + d4.compareTo(d3));
	}
}
/*
 * Sample interaction: 12 11 2019 Enter the second date: 11 11 2011 The result
 * from comparing 12/11/2019 to 11/11/2011 is 2952
 * 
 * Enter the first date: 1 31 2019 Enter the second date: 12 25 2369 The result
 * from comparing 1/31/2019 to 12/25/2369 is -128163
 * 
 * Enter the first date: 10 4 8576 Enter the second date: 10 4 8576 The result
 * from comparing 10/4/8576 to 10/4/8576 is 0
 * 
 * The result from comparing 5/18/2021 to 1/31/2019 is 838
 * 
 * 
 * 
 */
