package problemTwo;
//*********************************************
// Karthik Malyala
//
// Class that contains the start method for the JavaFX application for converting Pounds to Kilograms and vice versa. It uses an object
// of the PoundsToKilogramsPane class to serve as the node for the specifically-sized scene.
//
//*********************************************

// Libraries needed to set the scene and stage for the JavaFX program
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PoundsToKilogramsJavaFX extends Application {
	// Start method
	public void start (Stage primaryStage) 
	{
		// Makes the object of the PoundsToKilogramsPane class the specific root node for the scene along with a
		// 400x150 dimension for the scene
		Scene scene = new Scene(new PoundsToKilogramsPane(), 400, 150); // See PoundsToKilogramsPane() class for reference
		primaryStage.setTitle("Pounds to Kilograms Converter"); // Sets the title of the stage
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/* Launches the JavaFX Application. The following method isn't really required
	 * as Eclipse launches the JavaFX Application automatically. However, it is included
	 * for reference!
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
