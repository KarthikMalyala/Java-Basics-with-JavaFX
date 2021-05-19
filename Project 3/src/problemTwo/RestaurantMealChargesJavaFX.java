package problemTwo;
//*********************************************
// Karthik Malyala
//
// Class that contains the start method for the JavaFX application for the Restaurant Meal Charges. It uses an object
// of the RestaurantMealChargesPane class to serve as the node for the specifically-sized scene.
//
//*********************************************

//Libraries needed to set the scene and stage for the JavaFX program
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestaurantMealChargesJavaFX extends Application {
	// Start Method
	public void start (Stage primaryStage) {
				// Makes the object of the RestaurantMealChargesPane class the specific root node for the scene along with a
				// 400x300 dimension for the scene
				Scene scene = new Scene(new RestaurantMealChargesPane(), 400, 300); // See RestaurantMealChargesPane() class for reference
				primaryStage.setTitle("Restaurant Meal Charges"); // Sets the title of the stage
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
