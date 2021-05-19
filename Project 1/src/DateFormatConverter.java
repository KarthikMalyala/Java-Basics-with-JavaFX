//*********************************************
// Karthik Malyala
//
// This program reads a string for a date in the format month/day/year and displays it in the format day.month.year, which 
// is a typical format used in Europe. For example, if the input is 06/17/2020, the output should be 17.06.2020.
//
//*********************************************

import java.util.Scanner; //Imports the Scanner Class to read user's input

public class DateFormatConverter {

	public static void main(String[] args) {
		String date; // String created to store user's input
		Scanner scan = new Scanner(System.in); // Creates an object to read input
		
		// Prompts the user to enter a date in the format of month/day/year
		System.out.println("Enter a date using the month/day/year format:");
		date = scan.nextLine();
	
		// Initializes strings that would take the substring of the dat format used to separate the month, day, and year
		String month = date.substring(0,2);
		String day = date.substring(3,5);
		String year = date.substring(6,10);
		
		// Initializes another final string that compiles the date in the European format with the three substrings above
		String euroDate = (day + "." + month + "." + year);
		
		// Prints the European Date format using string concatenation
		System.out.println("European date format for " + date + " is " + euroDate);
		
		scan.close(); // Closes the scan object to avoid a resource leak

	}

}
