package problemOne;
//*********************************************
// Karthik Malyala
//
// A test class that acts as a program that allows a user to encode and decode messages entered from the keyboard. This program
// creates a SubstitutionCipher object and it prompts the user repetitively until they enter 3 (quit). In each iteration of the loop,
// the user is asked to pick an action and a shift value for the plain text/ cipher text. The program will then convert it accordingly
// using the abstract methods that were defined in SubstitutionCipher.
//
//*********************************************
import java.util.Scanner; // To read input from the user

public class CipherTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		SubstitutionCipher cipher = new SubstitutionCipher(); // SubstitutionCipher object
		
		// Utilizes a while loop to prompt the user repetitively until 3 (quit) is inputted
		while(loop){
			System.out.println("Select an Action:");
			System.out.println("1. Encrypt a Message");
			System.out.println("2. Decrypt a Message");
			System.out.println("3. Quit");
			scan.hasNextLine();
			int input = scan.nextInt();
			
			// Uses a switch statement to set a function for each case of the user's input
			switch (input) 
			{
				// Encode a message
				case 1: {
					 System.out.println("Please enter the number of shifts.");
					 int shift = scan.nextInt();
					 cipher.setShift(shift); // Sets the shift
					 System.out.println("Please enter your Plain Text.");
					 scan.nextLine();
					 String textInp = scan.nextLine();
					 cipher.setPlainText(textInp); // Sets the plain text to what the user has entered
					 // Calls the encode method to generate the encrypted message
					 System.out.println("Cipher Text: " + cipher.Encode() + "\n"); 
					 break;
				}	
				// Decode a message
				case 2:{
					 System.out.println("Please enter the number of shifts.");
					 int shift = scan.nextInt();
					 cipher.setShift(shift); // Sets the shift
					 System.out.println("Please enter your Cipher Text.");
					 scan.nextLine();
					 String textInp = scan.nextLine();
					 cipher.setCipherText(textInp); // Sets the cipher text to what the user has entered
					// Calls the decode method to generate the decrypted message
					 System.out.println("Plain Text: " + cipher.Decode() + "\n");
					 break;
				}
				// Quit
				case 3:{
					loop = false; // Breaks the while loop
					break;
				}
				// Invalid Input Test
				default:{
				 System.out.println("Invalid Input. Please try again\n");
				 break;
				} 
			}
		}
		scan.close(); // Avoids a resource leak
	}
}
