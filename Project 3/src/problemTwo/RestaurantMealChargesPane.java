package problemTwo;
//*********************************************
// Karthik Malyala
//
// This program is a pane class that demonstrates the use of GridPane, labels, buttons, TextFields, ActionEvent handlers, Radio Buttons,
// toggle group, and GUI element organization for calculating the total a. This pane class is then used in the PoundsToKilogramsJavaFX
// class as a node to set up the JavaFX screen
//
//*********************************************

//Imports the necessary libraries for creating buttons, labels, text fields, gridpane, toggle groups, radio buttons, and action events
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.text.NumberFormat;

public class RestaurantMealChargesPane extends GridPane {
	// Creates objects that will then be used in the JavaFX application and the GUI
	private Text prompt;
	private TextField costEntry;
	private Label tipResult, taxResult, total;
	private RadioButton zeroP, tenP, fifteenP, eighteenP;
	
	public RestaurantMealChargesPane() {
		// Default prompt that prompts the user to enter a meal charge and select a tip percentage
		prompt = new Text("Please enter meal charge then select a tip percentage:");
		// Creates a text field where the user can enter the meal charge
		costEntry = new TextField();
		costEntry.setAlignment(Pos.CENTER); // sets the cursor to the center
		// Label for the Tip Amount that defaults at $0.00
		tipResult = new Label ("Tip Amount: $0.00");
		// Label for the Tax Amount that defaults at $0.00
		taxResult = new Label ("Tax Amount: $0.00");
		// Label for the Total Amount that defaults at $0.00
		total = new Label ("Total Amount: $0.00");
		
		// Make sures that only a single toggle may be selected at any given time
		ToggleGroup group = new ToggleGroup();
		
		// Radio Button for 0%
		zeroP = new RadioButton ("0%");
		zeroP.setSelected(true); // Sets the 0% tip percentage as the default 
		zeroP.setToggleGroup(group);
		
		// Radio Button for 10%
		tenP = new RadioButton ("10%");
		tenP.setToggleGroup(group);
		
		// Radio Button for 15%
		fifteenP = new RadioButton ("15%");
		fifteenP.setToggleGroup(group);
		
		// Radio Button for 18%
		eighteenP = new RadioButton ("18%");
		eighteenP.setToggleGroup(group);
		
		// Creates a button that prompts the processTotalCosts action event handler which calculates and computes the result
		Button calculate = new Button ("Calculate Total");
		calculate.setOnAction(this::processTotalCosts);
		
		// Creates a horizontal layout where the radio buttons are arranged as nodes in a single row
		HBox options = new HBox (zeroP, tenP, fifteenP, eighteenP);
		options.setAlignment(Pos.CENTER);
		options.setSpacing(5);
		
		// Creates a vertical layout of the output statements where they are arranged in a single column
		VBox results = new VBox (tipResult, taxResult, total, calculate);
		results.setAlignment(Pos.CENTER);
		results.setSpacing(10);
		
		// Sets the dimensions, alignment, and color of the grid pane
		setHgap(2);
		setVgap(4);
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color: lightblue");
		
		// Through inheritance, the RestaurantMealChargesPane is a GridPane, and inherits the add method.
		// The parameters to the add method specify to which grid cell the node is added. Through this, we can arrange all the 
		// nodes in the grid. 
		add(prompt, 5, 0);
		add(costEntry, 5, 1);
		add(options, 5, 2); // Adds the Radio Buttons in one horizontal row using HBox
		add(results, 5, 3); // Adds the output statements in one single column using VBox
		
	}
	
	// The processTotalCosts method is used to used to define the event handler that is triggered when the user presses 
	// the "Calculate Total" button which is associated with a call to its setOnAction method.
	// This method obtains the text from the text field using a call to the getText method, which returns a character string. 
	// The text is then converted to a double using the parseDouble method of the Double wrapper class. It then processes the radio button selection 
	// and the input from the user and use an if-else structure to decide the tip percent and calculate the final outputs. It then calculates the values 
	// and sets the labels created above to display the calculated results.
	public void processTotalCosts (ActionEvent Event){
		
		final double salesTAX = 0.08; // Constant for the sales tax
		double tip = 0.00; // Initializes the tip to 0.00
		double cost = Double.parseDouble(costEntry.getText()); // Obtains the the text from the text field and converts it into a double
		
		// If-else structure to determine the tip percent
		if (zeroP.isSelected()) {
			tip = 0.00;
		}
		else if (tenP.isSelected()) {
			tip = 0.10;
		}
		else if (fifteenP.isSelected()) {
			tip = 0.15;
		}
		else {
			tip = 0.18;
		}
		
		// Uses numberFormat to convert the values into a currency format
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		
		// Final calculations
		double tipAmount = (cost*tip);
		double salesTax = (cost * salesTAX); 
		double totalAmount = (cost + tipAmount + salesTax);
		
		// Sets the text for the labels to display the final results
		tipResult.setText("Tip Amount: " + numberFormat.format(tipAmount));
		taxResult.setText("Tax Amount: " + numberFormat.format(salesTax));
		total.setText("Total Amount: " + numberFormat.format(totalAmount));
	}
}
