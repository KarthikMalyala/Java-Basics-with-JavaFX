package problemTwo;
//*********************************************
// Karthik Malyala
// 
// This program is a pane class that demonstrates the use of GridPane, labels, buttons, TextFields, ActionEvent handlers, 
// and GUI element organization for converting Pounds to Kilograms or vice versa. This pane class is then used in the PoundsToKilogramsJavaFX
// class as a node to set up the JavaFX screen
//
//*********************************************

// Imports the necessary libraries for creating buttons, labels, text fields, gridpane, and action events
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.lang.Math;

public class PoundsToKilogramsPane extends GridPane {
	
	// Creates objects that will then be used in the JavaFX application and the GUI
	private Label result;
	private TextField weightEntry;
	
	public PoundsToKilogramsPane()
	{
		result = new Label ("-----"); // Creates a default result label using the private object created above for when the user first opens the application
		Label weight = new Label ("Enter weight in Pounds/Kilograms: "); // Creates a label that prompts the user to enter a weight in the text field next to it
		weightEntry = new TextField(); // Creates the text field using the private object created outside of the constructor for the user to enter the weight
		
		// Creates a button that prompts the processLbsToKg action event handler which calculates and computes the result 
		Button lbsToKg = new Button ("Convert to Kilograms");
		lbsToKg.setOnAction(this::processLbsToKg);
		
		// Creates a button that prompts the processKgToLbs action event handler which calculates and computes the result
		Button kgToLbs = new Button ("Convert to Pounds");
		kgToLbs.setOnAction(this::processKgToLbs);
		
		// Sets the dimensions, alignment, and color of the grid pane
		setHgap(3);
		setVgap(3);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: lightblue");
		
		// Through inheritance, the PoundsToKilogramsPane is a GridPane, and inherits the add method.
		// The parameters to the add method specify to which grid cell the node is added. Through this, we can arrange all the 
		// nodes in the grid. 
		add(weight, 0, 0);
		add(weightEntry, 1, 0);
		add(lbsToKg, 0, 5);
		add(kgToLbs, 1, 5);
		add(result, 0, 10);

	}
	
	// The processLbsToKg method is used to define the event handler that is triggered when the user presses 
	// the "Convert to Kilograms" button which is associated with a call to its setOnAction method.
	// This method obtains the text from the text field using a call to the getText method, which returns a character string. 
	// The text is then converted to a double using the parseDouble method of the Double wrapper class. 
	// Then, the method performs the calculation to determine the equivalent weight in kilograms and returns it after rounding it to two decimal places
	public void processLbsToKg (ActionEvent event)
	{
		final double lbsToKg = 0.453592; // Constant for weight conversion
		double weight = Double.parseDouble(weightEntry.getText());
		double convertedWeight = Math.round((weight * lbsToKg)*100.0)/100.0; // Rounds to two decimal places
		result.setText(weight + " Pound(s)" + " --->" + convertedWeight + " Kilogram(s)"); // Sets the result label as the string showing the conversion
	}
	
	// The processKgToLbs method uses the same structure and process as the processLbsToKg except that this method is carrying 
	// out the calculations to convert from Kilograms to Pounds using the event handler and the same techniques as above.
	public void processKgToLbs (ActionEvent event)
	{
		final double kgToLbs = 2.20462; // Constant for weight conversion
		double weight = Double.parseDouble(weightEntry.getText()); // Obtains the the text from the text field and converts it into a double
		double convertedWeight = Math.round((weight * kgToLbs)*100.0)/100.0; // Rounds to two decimal places
		result.setText(weight + " Kilogram(s)" + " --->" + convertedWeight + " Pound(s)"); // Sets the result label as the string showing the conversion
	}

}
