package problemOne;
//*********************************************
// Karthik Malyala
//
// A client class that maintains a list of NewsPaperScribers created by a user. It prompts a user for the subscriber’s 
// address and requested service, and then creates the appropriate object based on the service type. In addition, it does not 
// allow the user to enter more than one subscription type for any given street address and displays the list of subscribers at the end
//
//*********************************************
import java.util.Scanner; // Required to read input
public class Subscribers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		NewsPaperSubscriber subscriberList[] = new NewsPaperSubscriber[1]; // Array for the list of Subscribers
		int i = 0;
		boolean loop = true;
		
		// Increases the size of the subscriberList array according to the user's preference
		while (loop) {
			if (i >= subscriberList.length-1) {
				NewsPaperSubscriber temporary[] = new NewsPaperSubscriber [i+1];
				for (int j = 0; j < subscriberList.length; j++) {
					temporary[j] = subscriberList[j];
				}
				subscriberList = temporary;
			}
			// Main menu options
			System.out.println("(1) List all Subscriptions");
			System.out.println("(2) Add a Subscription");
			System.out.println("(3) Quit");
			int input = scan.nextInt();
			
			// Switch statement to handle each input case of the main menu
			switch(input) {
				// Lists all the subscription details using the subscriberList array
				case 1:
					{
					for (int k = 0; k < i; k++) {
						String subscriber = subscriberList[k].toString();
						System.out.println(subscriber);
						System.out.println("\n");
					}
					break;
				}
				
				// Allows the user to add a subscription depending on what type of subscription they prefer
				case 2:
				{
					// List of subscriptions
					System.out.println("Choose the type of subscription: ");
					System.out.println("(1) Seven Day Subscription");
					System.out.println("(2) Weekday Subscription");
					System.out.println("(3) Weekend Subscription");
					System.out.println("(Default) Exit to Main Menu");
					int choice = scan.nextInt();
					
					// A nested switch statement to handle the preferred type of subscription from the user
					switch(choice) {
						// Seven-Day Subscription option
						case 1:
							{
								System.out.println("Please enter your address:");
								scan.nextLine();
								String address = scan.nextLine();
								subscriberList[i] = new SevenDaySubscriber(address); // Stores the street address in the array using the constructor
								
								// Test to see if the address is equal which in that case, the user won't be able to register for more than one
								// type of subscription service for the same address
								if (subscriberList[i].equals(subscriberList)) {
									System.out.println("You cannot enter more than one subscription type for the same address.\n");
									break;
								}
								
								// Calls the setRate method to set the subscription rate
								subscriberList[i].setRate();
								System.out.println("Subscription Created!\n");
								i++; // Goes onto the next placeholder of the array
								break;
							}
						// Weekday Subscription option
						case 2:
							{
								System.out.println("Please enter your address:");
								scan.nextLine();
								String address = scan.nextLine();
								subscriberList[i] = new WeekdaySubscriber(address); // Stores the street address in the array using the constructor
								
								// Test to see if the address is equal which in that case, the user won't be able to register for more than one
								// type of subscription service for the same address
								if (subscriberList[i].equals(subscriberList)) {
									System.out.println("You cannot enter more than one subscription type for the same address.\n");
									break;
								}
								// Calls the setRate method to set the subscription rate
								subscriberList[i].setRate();
								System.out.println("Subscription Created!\n");
								i++; // Goes onto the next placeholder of the array
								break;
							
							}
						// Weekend Subscription option
						case 3:
							{
								System.out.println("Please enter your address:");
								scan.nextLine();
								String address = scan.nextLine();
								subscriberList[i] = new WeekendSubscriber(address); // Stores the street address in the array using the constructor
								
								// Test to see if the address is equal which in that case, the user won't be able to register for more than one
								// type of subscription service for the same address
								if (subscriberList[i].equals(subscriberList)) {
									System.out.println("You cannot enter more than one subscription type for the same address.\n");
									break;
								}
								// Calls the setRate method to set the subscription rate
								subscriberList[i].setRate();
								System.out.println("Subscription Created!\n");
								i++; // Goes onto the next placeholder of the array
								break;
							}
						// Default statement for invalid input
						default:
							{
								System.out.println("Invalid Input");
								break;
							}
					}
					break;
				}
				// Quits from the main menu
				case 3:
					{
						loop = false;
						break;
					}
				// Default statement for the main menu
				default:
					{
						System.out.println("Invalid Input. Try Again");
						break;
					}
			}	
		}
		scan.close(); // Avoids a resource leak
	}
}
