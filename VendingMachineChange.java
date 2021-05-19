//*********************************************
// Karthik Malyala
//
// This program determines the change to be dispensed from a vending machine. An item in the machine can cost between 25 cents and 
// a dollar, in 5-cent increments (i.e., 25, 30, 35, 40, …. , 90, 95, 100). The machine accepts only single dollar bill to 
// pay for the item
//
//*********************************************

import java.util.Scanner; //Imports the Scanner Class to read user's input

public class VendingMachineChange {

	public static void main(String[] args) {
		int input;
		Scanner scan = new Scanner(System.in); // Creates an object to read input
		
		// Prompts the user for the price of the item and then scans it
		System.out.println("Enter a price of item (from 25 cents to a dollar, in 5-cent increments):");
		input = scan.nextInt();
		
		// Tests if the user input is valid through an if-else statement
		if (input % 5 == 0 && (input >= 25 && input <= 100)) {
			System.out.println("\nYou bought an item for " + input + " cents and gave me a dollar.");
			
			// Determines the change required by subtracting the price from the amount inserted (100 cents)
			int change;
			change = (100 - input);
			
			/* Determines how many quarters are required through division. The program then alters the change
			 variable by using the modulus operator to figure out how much of the change is left */
			int quarters = (change / 25);
			change = (change % 25);
			
			/* Determines how many dimes are required through division. The program once again alters the change
			  variable by using the modulus operator to figure out how much of the change is left after using the quarters and dimes*/
			int dimes = (change / 10);
			change = (change % 10);
			
			// Finally calculates the amount of required nickels with the leftover change after using quarters and dimes
			int nickels = (change / 5);
			
			// Using the println statements, the program then prints out the variable values calculated above for each coin
			System.out.println("So your change is");
			System.out.println(quarters + " quarter(s)");
			System.out.println(dimes + " dime(s), and");
			System.out.println(nickels + " nickel.");
		}
		
		// The else statement informs the user that the price they entered is invalid
		// This means that the entered value was either less than 25, more than 100, or the value was not divisible by 5
		else {
			System.out.println("Invalid Input. The price has to be between 25 cents and a dollar, in 5-cent increments.");
		}
		
		scan.close(); // Avoids a resource leak and closes the scan object
	}

}
