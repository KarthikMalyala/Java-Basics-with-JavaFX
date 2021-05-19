package problemTwo;
//*********************************************
// Karthik Malyala
//
// A client class called ContactBuilder that builds a list of Contact objects, using an array of maximum size of 10. it allows a 
// user to enter values for a contact. It also catches and handles the PhoneNumberException if it is thrown due to creating 
// unacceptable Contact object that does not satisfy the phone number format. The exception is handled by displaying an appropriate 
// message while an appropriate message is output when a Contact object is created successfully. At the end, it displays 
// the list of all accepted contacts.
//
//*********************************************

//Used to read input from the user. Better than Scanner class for our purposes
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
public class ContactBuilder {
	// Main method
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Contact contacts[] = new Contact[10]; // contacts array initialized
		boolean loop = true;
		int i = 0;
		String name = "";
		String phone = "";
		
		// While loop that prompts the user to enter the required details for a phonebook. Doesn't loop when i = 10 because
		// that is the maximum size of the array. When i = 10, the loop does not run, and outputs the 10 accepted contacts
		while(i < 10 && loop) {
			System.out.println("Enter the name: ");
			name = read.readLine();
			
			System.out.println("Enter the phone number: ");
		    phone = read.readLine();
		   
			try {
				// Passes the inputs into the Contact constructor and sets it to the i placeholder of the contacts array
				contacts[i] = new Contact (name, phone); 
			}
			catch(PhoneNumberException error) {
				System.out.println(error.getMessage()); 
				i--; // Resets to the i value it was currently working on
			}
			
			// Prompts the user for another option if they want to add additional contact
			System.out.println("\nDo you want to add an additional contact? (Y/N)");
			char choice = read.readLine().charAt(0);
			
			if (choice == 'n' || choice == 'N') {
				loop = false;
			}
			else {
				// Proceeds to the next placeholder of the array
				i++;
				loop = true;
			}
		}
		
		// Neatly prints out the contact list using the toString method of the Contact class
		// Prints out the allowed 10 Contacts
		System.out.println("-----------------------");
		System.out.println("Contact List:");
		for (int j = 0; j < i; j++) {
			String output = contacts[j].toString();
			System.out.println(output);
		}
	}

}
