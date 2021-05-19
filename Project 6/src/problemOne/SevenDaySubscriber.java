package problemOne;
//*********************************************
// Karthik Malyala
//
// Includes the child class of the NewsPaperSubscriber class called SevenDaySubscriber that has a constructor with a string
// parameter to initialize the street address and calls the setRate() abstract method to set the rate, which in the case of a 
// seven-day subscriber is $10.5. In addition, it includes a toString method that outputs subscription info
//
//*********************************************
public class SevenDaySubscriber extends NewsPaperSubscriber {
	// Constructor with string parameter
	public SevenDaySubscriber(String strAddress) {
		// TODO Auto-generated constructor stub
		super(strAddress);
	}
	
	// Calls the abstract method to set the rate
	public void setRate() {
		subscriptionRate = 10.5;
	}
	
	// A neatly formatted toString method that outputs a seven-day subscriber's subscription info
	public String toString() {
		String result = "Street Address: " + getStreetAddress();
		result += "\nSubscription Rate: $" + getRate();
		result += "\nService Type: Seven-Day Subscription";
		
		return result;
	}

}
