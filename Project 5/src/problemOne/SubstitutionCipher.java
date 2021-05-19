package problemOne;
//*********************************************
// Karthik Malyala
//
// SubstitutionCipher class that is derived from the Cipher class that adds an additional instance variable called shift. This class
// has two constructors: one with no parameters, and the second with string and integer parameters. The string parameter initializes its
// PlainText variable, and the integer parameter initializes the shift variable. In addition to mutator and accessor methods, this program
// also defines the abstract methods Encode and Decode with no parameters to encrypt or decrypt an inputted message from the user using the
// ASCII Character table.
//
//*********************************************

public class SubstitutionCipher extends Cipher{
	// Instance Variable
	private int shift;
	// Constructor with no parameters passed
	public SubstitutionCipher() {
		// TODO Auto-generated constructor stub
		super("");
		shift = 0;
	}
	// Constructor that has a string and an integer parameter passed
	public SubstitutionCipher (String plainTextInp, int shiftInp) {
		super(plainTextInp);
		shift = shiftInp;
	}
	
	// Getter and setter methods for the instance variable Shift
	public void setShift(int shiftInp) {
		shift = shiftInp;
	}

	public int getShift() {
		return shift;
	}
	
	// Encode Abstract Method from Cipher class definition
	// Uses ASCII Character Chart/Table to make the conversions according to the shift
	public String Encode() {
		char encryptedMessage[] = getPlainText().toCharArray(); // Stores the plain text in an array
		
		// Transforms every character in the array according to the shift and replaces it with the ASCII Character
		// at the integer value after the shift
		for (int i = 0; i < encryptedMessage.length; i++) {
			int j = (int)(encryptedMessage[i]) + getShift();
			encryptedMessage[i] = (char)j;
		}
		// Returns the string from the array of encrypted shifted characters
		return String.valueOf(encryptedMessage);
	}
	
	// Encode Abstract Method from Cipher class definition
	// Uses ASCII Character Chart/Table to make the conversions according to the shift
	public String Decode() {
		char decryptedMessage[] = getCipherText().toCharArray(); // Stores the Cipher text in an array
		
		// Transforms every character in the array according to the shift and replaces it with the ASCII Character
		// at the integer value after the shift
		for (int i = 0; i < decryptedMessage.length; i++) {
			int j = (int)(decryptedMessage[i]) - getShift();
			decryptedMessage[i] = (char)j;
		}
		// Returns the string from the array of decrypted shifted characters
		return String.valueOf(decryptedMessage);
	}
}
