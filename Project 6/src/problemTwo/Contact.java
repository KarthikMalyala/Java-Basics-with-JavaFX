package problemTwo;
//*********************************************
// Karthik Malyala
//
// A class called Contact that has  two instance variables, Name and Phone as Strings. It's constructor accepts values for 
// initializing the instance variables and uses two methods for setting the instance variables: setName() and setPhone(). 
// The setPhone() method throws a PhoneNumberException when a phone number does not satisfy the North American Phone number format. 
// Includes a method for returning the Phone, called getPhone() and toString() method to display a Contact object information. 
//
//*********************************************
public class Contact {
	// Instance variables 
	private String Name;
	private String Phone;
	
	// Constructor with String parameters
	public Contact(String nameInp, String phoneInp) throws PhoneNumberException{
		// TODO Auto-generated constructor stub
		setName(nameInp);
		Phone = setPhone(phoneInp);
	}
	
	// Getter and setter methods
	public void setName(String nameInp) {
		Name = nameInp;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public String setPhone(String phoneInp) throws PhoneNumberException{
		Phone = phoneInp;
		// Removes all the dashes in the user input and then processes the number
		String tempNum = Phone.replaceAll("[-]", "");
		PhoneNumberException error;
		int length = tempNum.length();
		
		// Checks the number and tests if it has all digits
		for (int i = 0; i < tempNum.length(); i++) {
			if (!Character.isDigit(tempNum.charAt(i))) {
				error = new PhoneNumberException("Invalid Phone Number (Non-Digit Characters). Please try again");
				throw error;
			}
		}
		
		// Tests for the local number format
		if (length == 7) {
			if (tempNum.charAt(0)>='2' && tempNum.charAt(0)<='9') {
				System.out.println("Contact Added!");
				return getPhone();
			}
			// Throws the exception in case it doesn't meet the format requirements 
			else {
				error = new PhoneNumberException("Invalid Phone Number (First Digit should be 2-9). Please try again");
				throw error;
			}
		}
		
		// Tests for the domestic number format
		else if (length == 10) {
			if(Character.isDigit(tempNum.charAt(0)) && Character.isDigit(tempNum.charAt(1)) && Character.isDigit(tempNum.charAt(2)) && tempNum.charAt(3)>='2' && tempNum.charAt(3)<='9') {
				System.out.println("Contact Added!");
				return getPhone();
			}
			// Throws the exception in case it doesn't meet the format requirements 
			else {
				error = new PhoneNumberException("Invalid Phone Number (Area Code + Fourth Digit should be 2-9). Please try again");
				throw error;
			}
		}
		
		// If all else, throws that the number is invalid
		else {
			error = new PhoneNumberException("Invalid Phone Number. Please try again");
			throw error;
		}
	}
	
	// toString method that lists the name and phone number for the specific contact
	public String toString() {
		String output = "Name: " + getName();
		output += "\nPhone: " + getPhone();
		output += "\n";
		
		return output;
	}
}
