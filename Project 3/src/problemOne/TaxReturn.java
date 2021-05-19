package problemOne;
//*********************************************
// Karthik Malyala
//
// A TaxReturn class that encapsulates the concept of a tax return using private instance variables holding a user's Social Security Number,
// last name, first name, street address, city, state, zip code, annual income, marital status, and tax liability. It includes a constructor that
// passes parameters and provides values for all of the instance variables as well as sets the annual income and tax liability to 0.0. The class also includes
// setter methods for annual income and marital status and getter methods for income, tax liability, and SSN. 
// Also includes a toString method towards the end that formats the outputs in a string.
// 
//*********************************************

import java.text.NumberFormat; // Used to convert the numbers to a currency format.

public class TaxReturn {
	
	// Declares the private instance variables used in the program
	private String fName;
	private String lName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String SSN;
	private String maritalStatus;
	private double salary;
	private double tax;
	
	// Declares the constructor with parameters and initializes the private instance variables created above.
	public TaxReturn(String firstName, String lastName, String addressInput, String cityInput, String stateInput, String zipCodeInput, String ssnInput) {
		fName = firstName;
		lName = lastName;
		address = addressInput;
		city = cityInput;
		state = stateInput;
		zipCode = zipCodeInput;
		SSN = ssnInput;
		maritalStatus = "";
		salary = 0.00; // Sets the double variables to 0.00
		tax = 0.00;
	}
	
	// Creates an object for the currency conversion
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
	
	// Setter methods for Marital Status and Annual Income
	public void setMaritalStatus (String mStatusInput) {
		maritalStatus = mStatusInput;
	}
	public void setSalary (double annualIncome) {
		double taxRate = 0.00; // Initializes the taxRate variable to 0.00
		salary = annualIncome; // Sets the salary instance variable to the income parameter 
		
		/* Checks the criteria for various tax rates and decides on a tax rate using conditional statements
		   and boolean expressions to match the table of values and criteria given in the prompt
		   Uses the .equals operator to check the string for marital status and then decides the respective tax rate
		   in a if-else structure */
		
		if (salary <= 20000) {
			if (maritalStatus.equals("single") || maritalStatus.equals("married")) {
				taxRate = 0.00;
			}
		}
		else if (salary >= 20001 && salary <= 50000) {
			if (maritalStatus.equals("single")) {
				taxRate = 0.15;
			}
			else {
				taxRate = 0.10;
			}
		}
		else if (salary >= 50001 && salary <= 100000) {
			if (maritalStatus.equals("single")) {
				taxRate = 0.20;
			}
			else {
				taxRate = 0.15;
			}
		}
		else {
			if (maritalStatus.equals("single")) {
				taxRate = 0.30;
			}
			else {
				taxRate = 0.25;
			}
		}
		
		tax = taxRate * salary;
	}
	
	// Getter methods for annual income, tax liability, and social security number
	public double getSalary() {
		return salary;
	}
	public double getTax() {
		return tax;
	}
	public String getSSN () {
		return SSN;
	}
	
	// The toString method that returns all the values of the class instance variables in a multi-line format
	public String toString() {
		String result = "Amount of tax liability: " + numberFormat.format(getTax());
		result += "\nTax Payer Information: ";
		result += "\nTax Payer Name: "+ lName +", "+ fName;
		result += "\nSocial Security Number: " + getSSN();
		result += "\nAddress: "+address+", "+ city +", "+ state +", " + zipCode ;
		result += "\nAnnual Income: "+ numberFormat.format(getSalary());
		result += "\nTax Amount: " + numberFormat.format(getTax());
		
		return result;
	}
}
