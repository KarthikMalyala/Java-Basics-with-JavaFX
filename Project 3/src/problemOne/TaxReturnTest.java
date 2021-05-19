package problemOne;
//*********************************************
// Karthik Malyala
//
// A test program that prompts the user for the data needed to create an object of the TaxReturn class. This class uses several
// do-while loops that continue to prompt the user for data if it has been entered invalidly. The loops check for the correct format
// of the SSN, zip code, marital status, and annual income. It then creates an object of the TaxReturn class and calls the methods within
// it for the structured output.
//
//*********************************************

import java.util.Scanner; // Needed to read input from the user

public class TaxReturnTest {

	public static void main(String[] args) {
	    Scanner scan = new Scanner (System.in); // Creates an object of the Scanner class to read input from the user
	    // Creates separate variables that will be passed as parameters for the TaxReturn constructor.
		String firstName;
		String lastName;
		String addressInput;
		String cityInput;
		String stateInput;
		String zipCodeInput;
		String ssnInput;
		String maritalStatus = "";
		double annualIncome;
		
		boolean tryAgain = true; // Boolean for the do-while loops that would run the loop again if the user had  entered an invalid statement 
					
		System.out.println("Please enter a tax payer's Last name: ");
		lastName = scan.nextLine();
		
		System.out.println("Please enter a tax payer's First Name: ");
		firstName = scan.nextLine();
		
		System.out.println("Please enter a tax payer's Address: ");
		addressInput = scan.nextLine();
		
		System.out.println("Tax payer's city: ");
		cityInput = scan.nextLine();
		
		System.out.println("Tax payer's state: ");
		stateInput = scan.nextLine();
		
		// do-while loop that would check the length of the zip code using Boolean expressions and .length() operator
		// Sets the boolean tryAgain = false if the input is valid
		do {
			System.out.println("Zip Code: ");
			zipCodeInput = scan.nextLine();
			if (zipCodeInput.length() == 5) {
				tryAgain = false; // The loop wouldn't run again
			}
			else {
				System.out.println("Incorrect Zip Code.");
			}
		}
		while (tryAgain == true);
		
		tryAgain = true; // Sets the Boolean back to true for the next do-while loop
		// Checks if the length and the dashes of the SSN entered are accurate and at the right indexes
		do {
			System.out.println("Tax payer's Social Security Number: ");
			ssnInput = scan.nextLine();
			if (ssnInput.length() == 11 && ssnInput.charAt(3) == '-' && ssnInput.charAt(6) == '-') { // Uses .charAt() and .length() operators to check the validity of the SSN
				tryAgain = false; // Loop will not run again
			}
			else {
				System.out.println("Incorrect social security number");
			}
		}
		while (tryAgain == true);
		
		tryAgain = true; // Re-declaration of the boolean tryAgain
		// Checks if the marital status' first character is accurate
		do {
			System.out.println("Marital Status: ");
			maritalStatus = scan.nextLine();
			// Uses the possible marital status first characters to check the validity of the input
			if (maritalStatus.charAt(0) == 's' || maritalStatus.charAt(0) == 'S' || maritalStatus.charAt(0) == 'm' || maritalStatus.charAt(0) == 'M') {
				tryAgain = false;
			}
			else {
				System.out.println("Incorrect marital status");
			}
		}
		while (tryAgain == true);
		
		tryAgain = true;
		// Checks if the annual income is negative
		do {
			System.out.println("Enter your annual income: ");
			annualIncome = scan.nextDouble();
			if (annualIncome >= 0) {
				tryAgain = false;
			}
			else {
				System.out.println("Invalid annual income.");
			}
		}
		while (tryAgain == true);
		
		// Creates an object of the TaxReturn class and passes the variables used in the main as the parameters for the constructor
		TaxReturn taxReturn = new TaxReturn(firstName, lastName, addressInput, cityInput, stateInput, zipCodeInput, ssnInput);
		taxReturn.setMaritalStatus(maritalStatus); // Calls the setMaritalStatus method to assign the marital status to the instance variable
		taxReturn.setSalary(annualIncome); // Calls the setSalary method to figure out the tax liability accordingly
		
		System.out.println(taxReturn.toString()); // Calls the toString method to print out the output in a multi-line format
		
		scan.close(); // Closes the scanner object to avoid resource leaks
	}

}
