package problemTwo;
//*********************************************
// Karthik Malyala
//
// An exception class called PhoneNumberException that has a constructor that accepts a String for a message to be displayed. 
// It is also designed to be thrown when a phone number does not satisfy North America phone number format. In addition, the 
// PhoneNumberException class should display an appropriate message when it is thrown.
//
//*********************************************
public class PhoneNumberException extends Exception{
	private static final long serialVersionUID = 1L;
	
	// Constructor that accepts the error message as the parameter
	public PhoneNumberException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
