//*********************************************
// Karthik Malyala
// 
// Generates a random Rectangle using a random width and height in the range 21-50, that is displayed at a random
// location in a 300x300 window. The rectangle is filled with a random color created by using the rgb method of the Color class.
// Each time the program is run it will display a rectangle with different width and height at a random location with a different color
//
//*********************************************

import java.util.Random; // Enables the randomization process

// Imports all the respective JavaFX classes and objects that would help in generating a rectangle
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class RandomRectangleGenerator extends Application {
	// Start Method
	public void start (Stage primaryStage)
	{
		Random generator = new Random(); // Creates an object of the random class to generate random numbers
		
		// Declares all the variables used in this program
		int width;
		int height;
		int x;
		int y;
		// Constants for the window (scene) width and height
		final int canvasWidth = 300;
		final int canvasHeight = 300;
		
		// Generates a random width and height within the range of 21-50
		width = generator.nextInt(30) + 21;
		height = generator.nextInt(30) + 21;
		
		// Generates a random location in x and y coordinates
		/* The randomizer makes sure that the rectangle doesn't go out of the display by 
		 * constraining the range up till the canvas width or height minus the height or 
		 * width of the reactangle. This ensures that the rectangle will stay within the window */
		x = generator.nextInt(canvasWidth - width);
		y = generator.nextInt(canvasHeight - height);
		
		Rectangle rectangle = new Rectangle(); // Creates an object for the rectangle shape
		
		// Sets the random values as the x, y, width, and height for the generated rectangle
		rectangle.setX(x);
		rectangle.setY(y);
		
		rectangle.setWidth(width);
		rectangle.setHeight(height);
		
		// Fills the rectangle with a random color every time
		rectangle.setFill(Color.rgb(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256)));
		
		
		// Sets the stroke color and width for the rectangle
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2);
		
		// The group serves as a root node of a scene which is displayed on the primary Stage
		Group root = new Group(rectangle);
		Scene scene = new Scene (root, canvasWidth, canvasHeight, Color.WHITE);
		
		// Initiates the primary Stage (window)
		primaryStage.setTitle("Random Rectangle Generator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/* Launches the JavaFX Application. The following method isn't really required
	 * as Eclipse launches the JavaFX Application automatically. However, it is included
	 * for reference!
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}


