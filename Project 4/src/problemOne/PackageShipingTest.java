package problemOne;
//*********************************************
// Karthik Malyala
//
// This main class will allow the user to create as many packages as they wish. Each of these packages is stored in a packageList as an 
// ArrayList object of Package objects. This program prompts the user for all the required fields. It checks for the zipCode being equal along
// with the shipping method and then applies the 10% discount by calling the applyDiscount() method. Finally, the program displays the contents of 
// the packageList ArrayList object on the screen and uses the Address and Package classes to calculate and produce proper output
//
//*********************************************

import java.util.Scanner; // Required for reading user input
import java.util.ArrayList; // Required for creating the ArrayList

public class PackageShipingTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // Scanner object to read user input
		ArrayList<Package> packageList = new ArrayList <Package>(); // packageList arrayList
		boolean loop = true; // Boolean to test if the user wants to enter another package
		
		// Temporary variables to store input. Will be passed as parameters into Address and Package Classes
		int weight;
		String shipMethod;
		String street;
		String city;
		String state;
		String zipCode;
	
		// While loop to allow the user to enter as many packages as possible
		while(loop){
			// Series of prompts for the user to enter the data
			System.out.println("Package Weight?");
			weight = scan.nextInt();
			
		    System.out.println("Shipping Method (Air, Ground, Sea):");
			shipMethod = scan.next();
			
			System.out.println("Street Address of Destination?");
			scan.nextLine();
			street = scan.nextLine();
			
			System.out.println("City of Destination?");
			city = scan.next();
			
			System.out.println("State of Destination?");
			state = scan.next();
			
			System.out.println("5 Digit Zip Code of Destination?");
			zipCode = scan.next();
			scan.nextLine();
			
			Address address = new Address (street, city, state, zipCode); // Makes an address object
			
			packageList.add(new Package (weight, shipMethod)); // Adds Package into the ArrayList
			packageList.get(packageList.size()-1).setDestination(address); // Sets the destination of the first package to the Address object
			
			packageOrganizer(packageList); // Calls the packageOrganizer method and passes the packageList array list in as the parameter
				
			System.out.println("Would you like to add another package? (Y or N)");
			char inp = scan.next().charAt(0);
			if (inp == 'N' || inp == 'n') {
				System.out.println("\n");
				break; // breaks the loop since the user no longer wants to continue
			}
		}
		
		// Prints out the content of the packageList arrayList
		for (int i = 0; i < packageList.size(); i++) {
			System.out.println(packageList.get(i));
			System.out.println("----------------------------------");
		}
		System.out.println("See you next time!");
		
		scan.close(); // Avoids a resource leak
	}
	
	// Checks if the zipCode for two addresses are same and if the shipping method for those two addresses are the same, and then calls
	// the applyDiscount() method to add a 10% discount given the fact that the packages have the same zipCode and shipping method
	public static void packageOrganizer (ArrayList<Package> packageOrganizer) {
		for (int i = 0; i < packageOrganizer.size(); i++) {
			for (int j = i + 1; j < packageOrganizer.size(); j++) {
				if (packageOrganizer.get(j).getDestination().equals(packageOrganizer.get(i).getDestination())) { // Comparison Test for ZipCode
					if (packageOrganizer.get(j).getShipMethod().equals(packageOrganizer.get(i).getShipMethod())) { // Comparison Test for shipping method
						packageOrganizer.get(i).applyDiscount();
						packageOrganizer.get(j).applyDiscount();
					}
				}
			}
		}
	}

}
