package problemOne;
//*********************************************
// Karthik Malyala
//
// An abstract class called Cipher that has two string variables, PlainText and CipherText. This class includes a constructor
// with one passes string parameter that used to initialize PlainText while CipherText is set to an empty string. In addition,
// this class includes non-abstract mutator and accessor methods for the instance variables as well as two abstract methods for
// Encode and Decode
//
//*********************************************

public abstract class Cipher {
	// Instance Variables
	private String PlainText, CipherText;
	// Constructor with one passed string parameter
	public Cipher(String plainTextInp) {
		// TODO Auto-generated constructor stub
		PlainText = plainTextInp;
		CipherText = "";
	}
	
	// Setter and Getter methods for the instance variables
	public void setPlainText (String plainTextInp) {
		PlainText = plainTextInp;
	}
	public String getPlainText() {
		return PlainText;
	}
	
	public void setCipherText (String cipherTextInp) {
		CipherText = cipherTextInp;
	}
	
	public String getCipherText () {
		return CipherText;
	}
	
	// Encode and Decode Abstract Methods
	public abstract String Encode();
	public abstract String Decode();
}
