package problemOne;
//*********************************************
// Karthik Malyala
//
// A Package class that encapsulates the concept of a package which contains instance variables for trackingID, Weight (in ounces), Cost, 
// Discount, shipMethod, and Destination. Shipping is an enumerated type that defines the constants of shipping methods (Air, Ground, Sea) and
// shipMethod is a variable of Shipping. It also includes a constructor that accepts arguments for weight and shipping method while calculating a 
// random 6 digit number for the trackingID. With a calculateCost() method, it determines the proper cost depending on the shipping method chosen
// and the weight (Table provided in prompt). In addition, there are accessor and mutator methods for weight, shipMethod, and Destination. There is also
// a applyDiscount() method for applying a 10% discount if the package is destined to the same zipCode using the same shipMethod.
//
//*********************************************

import java.util.Random;
import java.text.NumberFormat;

public class Package {
	
	// Shipping Enumerated type with all constants of shipping methods
	public static enum Shipping{
		Air, Ground, Sea
	}
	
	// Private instance variables
	private int TrackingID;
	private int Weight;
	private double Cost;
	private boolean Discount;
	Shipping shipMethod;
	Address Destination;
	
	// Package constructor that takes in a weightInp and method
	public Package(int weightInp, String method) {
		// TODO Auto-generated constructor stub
		Weight = weightInp; 
		
		// Takes the method string and assigns it to enumerated type variable with respect to the shipping method
		if(method.equals("Air")) {
			shipMethod = Shipping.Air;
		}
		else if (method.contentEquals("Ground")) {
			shipMethod = Shipping.Ground;
		}
		else {
			shipMethod = Shipping.Sea;	
		}
		
		// Generates a random trackingID with 6 digits
		Random random = new Random();
		TrackingID = random.nextInt(900000) + 100000;
		
		Cost = calculateCost(); // Calls the calculateCost() method and assigns it to Cost variable
		
	}
	
	private double calculateCost() {
		// If-else structure based on the table given in the prompt that determines the cost after determining the ship method and weight
		// Weight between 1 and 8 Ounces
		if (Weight >= 1 && Weight <= 8) {
			if (shipMethod == Shipping.Air) {
				Cost = 4.00;
			}
			else if (shipMethod == Shipping.Ground) {
				Cost = 1.80;
			}
			else if (shipMethod == Shipping.Sea) {
				Cost = 0.55;
			}
		}
		// Weight between 9 and 16 Ounces
		else if (Weight >= 9 && Weight <= 16) {
			if (shipMethod == Shipping.Air) {
				Cost = 6.00;
			}
			else if (shipMethod == Shipping.Ground) {
				Cost = 2.80;
			}
			else if (shipMethod == Shipping.Sea) {
				Cost = 1.50;
			}
		}
		// Weight equal to or above 17 Ounces
		else if (Weight >= 17) {
			if (shipMethod == Shipping.Air) {
				Cost = 9.00;
			}
			else if (shipMethod == Shipping.Ground) {
				Cost = 4.00;
			}
			else if (shipMethod == Shipping.Sea) {
			    Cost = 2.00;
			}
		}
		
		return Cost; // Returns the determined cost
	}
	
	// Setter method for weight that calls the calculateCost() method to re-determine the cost
	public void setWeight(int weight) {
		Weight = weight;
		Cost = calculateCost();
	}
	
	// Getter method for weight
	public int getWeight() {
		return Weight;
	}
	
	// Setter method that assigns shipMethod variable to the enumerated type variable and calls the calculateCost() method again
	public void setShipMethod(Shipping ShipMethod) {
		shipMethod = ShipMethod;
		Cost = calculateCost();
	}
	
	// Getter method that returns the value of the enumerated type variable
	public Shipping getShipMethod() {
		return shipMethod;
	}
	
	// Setter method for destination where it assigns the Address object to the parametric Address object
	public void setDestination (Address destination) {
		Destination = destination;
	}
	
	// Getter method for Destination
	public Address getDestination() {
		return Destination;
	}
	
	// applyDiscount() method that adds a 10% discount to the cost and alters the boolean value of Discount
	public double applyDiscount() {
		Discount = true;
		Cost = Cost - (Cost * 0.10);
		return Cost;
	}
	
	// Currency format object for the Cost 
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
	
	// toString method that outputs all the instance variables and calls the toString method from Address class to form
	// the final Package Info multi-line output
	public String toString() {
		String packageInfo = "Package Info: ";
		packageInfo += "\nWeight: " + getWeight() + " ounces";
		packageInfo += "\nShipping Method: by " + getShipMethod();
		packageInfo += "\nCost: " + numberFormat.format(Cost);
		packageInfo += "\nApplied Discount: ";
		if (Discount == true) {
			packageInfo += "Yes";
		}
		else {
			packageInfo += "No";
		}
		packageInfo += "\nTracking ID: " + TrackingID;
		packageInfo += "\n" + Destination.toString(); // Call to Address class toString method
		
		return packageInfo; // returns the multi-line string output
	}
	
}
