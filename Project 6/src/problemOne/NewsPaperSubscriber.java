package problemOne;
//*********************************************
// Karthik Malyala
//
// Abstract Class called NewsPaperSubcriber that has two instance variables for a subscriber’s street address and the subscription 
// rate. Include a constructor that receives one parameter to initialize the street address. Includes getter and setter methods for 
// instance variables. Has a setRate() abstract method and an equals() method to test address equivalence
//
//*********************************************
public abstract class NewsPaperSubscriber {
	// Instance Variables
	private String streetAddress;
	protected double subscriptionRate;
	
	// COnstrcutor with string parameter
	public NewsPaperSubscriber(String strAddress) {
		// TODO Auto-generated constructor stub
		super();
		streetAddress = strAddress;
	}

	// Setter and getter methods
	public void setStreetAddress (String strAddress) {
		streetAddress = strAddress;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	
	// Abstract setter method for subscription rate
	public abstract void setRate();
	
	public double getRate() {
		return subscriptionRate;
	}
	
	// Equals method that tests address equivalence within the list of newspaper subscribers.
	public boolean equals(NewsPaperSubscriber[] subscriberList) {
		boolean test = false;
		for (int i = subscriberList.length - 2; i >= 0 ; i--) {
			if (streetAddress.equals(subscriberList[i].streetAddress)) {
				test = true;
				i = -1;
			}	
		}
		return (test);
	}
}
