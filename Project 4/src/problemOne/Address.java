package problemOne;
//*********************************************
// Karthik Malyala
//
// An Address class that encapsulates the concept of an address that has a street address, city, state, and zipCode as string instance
// variables. This class also contains a constructor in which parameters are accepted and initialized with the instance variables. In addition,
// it has a toString method that outputs well-formatted address and an equals method that returns true if two address objects are the same, meaning
// they have the same zipCode. 
//
//*********************************************

public class Address {
	
	// Private String Instance variables
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
	// Constructor that takes in parameters to initialize the instance variables
	public Address(String streetInp, String cityInp, String stateInp, String zipCodeInp) {
		streetAddress = streetInp;
		city = cityInp;
		state = stateInp;
		zipCode = zipCodeInp;
	}
	
	// toString method that outputs the initialized variables
	public String toString() {
		String result = "Address: " + streetAddress;
		result += "\n" + city + ", " + state + " " + zipCode;
		return result;
	}
	
	// equals method to test if the zipCode of two Address objects are equal
	public boolean equals (Address address) {
		return zipCode.equals(address.zipCode);
	}
}
